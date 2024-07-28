import model.Classroom;
import model.Student;
import service.AssignmentService;
import service.ClassroomService;
import service.StudentService;
import util.Logger;
import util.State;

import java.util.List;
import java.util.Scanner;

public class VirtualClassroomManager {
    private final ClassroomService classroomService;
    private final StudentService studentService;
    private final AssignmentService assignmentService;
    private final Scanner scanner;
    private State state;

    public VirtualClassroomManager() {
        this.classroomService = new ClassroomService();
        this.studentService = new StudentService();
        this.assignmentService = new AssignmentService();
        this.scanner = new Scanner(System.in);
        this.state = State.RUNNING;
    }

    public void start() {
        Logger.log("Starting Virtual Classroom Manager...");
        System.out.println();
        showMenu();
        System.out.println();
        while (state == State.RUNNING) {
            try {
                System.out.print("> ");
                String command = scanner.nextLine();
                processCommand(command);
            } catch (Exception e) {
                Logger.log("An error occurred: " + e.getMessage());
            }
        }

        Logger.log("Exiting Virtual Classroom Manager...");
    }

    private void showMenu() {
        System.out.println("Available Commands:");
        System.out.println("add_classroom - Add a new classroom");
        System.out.println("remove_classroom - Remove an existing classroom");
        System.out.println("list_classrooms - List all classrooms");
        System.out.println("add_student - Add a new student to a classroom");
        System.out.println("schedule_assignment - Schedule an assignment for a classroom");
        System.out.println("submit_assignment - Submit an assignment for a student in a classroom");
        System.out.println("list_students - List all students in a classroom");
        System.out.println("exit - Exit the application");
        System.out.println("Please enter your command:");
    }

    private void processCommand(String command) {
        String[] parts = command.split(" ", 2);

        switch (parts[0]) {
            case "add_classroom":
                if (parts.length > 1) {
                    addClassroom(parts[1]);
                } else {
                    System.out.println("Please provide the classroom name.");
                }
                break;
            case "remove_classroom":
                if (parts.length > 1) {
                    removeClassroom(parts[1]);
                } else {
                    System.out.println("Please provide the classroom name.");
                }
                break;
            case "list_classrooms":
                listClassrooms();
                break;
            case "add_student":
                if (parts.length > 1) {
                    addStudentsToClassroom(parts[1]);
                } else {
                    System.out.println("Please provide classroom name and student details.");
                }
                break;
            case "schedule_assignment":
                if (parts.length > 1) {
                    scheduleAssignment(parts[1]);
                } else {
                    System.out.println("Please provide classroom name and assignment details.");
                }
                break;
            case "submit_assignment":
                if (parts.length > 1) {
                    submitAssignment(parts[1]);
                } else {
                    System.out.println("Please provide student ID, classroom name, and assignment details.");
                }
                break;
            case "list_students":
                if (parts.length > 1) {
                    listStudentsInClassroom(parts[1]);
                } else {
                    System.out.println("Please provide the classroom name.");
                }
                break;
            case "exit":
                state = State.EXIT;
                break;
            default:
                System.out.println("Unknown command. Please try again.");
                break;
        }
    }

    private void addClassroom(String name) {
        classroomService.addClassroom(name);
        Logger.log("Classroom " + name + " added.");
    }

    private void removeClassroom(String name) {
        if (classroomService.removeClassroom(name)) {
            Logger.log("Classroom " + name + " removed.");
        } else {
            Logger.log("Classroom " + name + " does not exist.");
        }
    }

    private void listClassrooms() {
        List<Classroom> classrooms = classroomService.getAllClassrooms();
        if (classrooms.isEmpty()) {
            System.out.println("No classrooms available.");
        } else {
            System.out.println("Classrooms:");
            classrooms.forEach(classroom -> System.out.println(classroom.getName()));
        }
    }

    private void addStudentsToClassroom(String details) {
        String[] parts = details.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("Please provide classroom name and number of students.");
            return;
        }
        String className = parts[0];
        int numberOfStudents;
        try {
            numberOfStudents = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            System.out.println("Please provide a valid number of students.");
            return;
        }

        Classroom classroom = classroomService.getClassroom(className);
        if (classroom != null) {
            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter student ID for student " + (i + 1) + ": ");
                String studentId = scanner.nextLine();
                studentService.addStudent(studentId, classroom);
                Logger.log("Student " + studentId + " added to " + className + ".");
            }
        } else {
            Logger.log("Classroom " + className + " does not exist.");
        }
    }

    private void scheduleAssignment(String details) {
        String[] parts = details.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("Please provide classroom name and assignment details.");
            return;
        }
        String className = parts[0];
        String assignmentDetails = parts[1];
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom != null) {
            assignmentService.scheduleAssignment(classroom, assignmentDetails);
            Logger.log("Assignment scheduled for " + className + ".");
        } else {
            Logger.log("Classroom " + className + " does not exist.");
        }
    }

    private void submitAssignment(String details) {
        String[] parts = details.split(" ", 3);
        if (parts.length < 3) {
            System.out.println("Please provide student ID, classroom name, and assignment details.");
            return;
        }
        String studentId = parts[0];
        String className = parts[1];
        String assignmentDetails = parts[2];

        Student student = studentService.getStudent(studentId);
        Classroom classroom = classroomService.getClassroom(className);
        if (student != null && classroom != null) {
            assignmentService.submitAssignment(student, classroom, assignmentDetails);
            Logger.log("Assignment submitted by " + studentId + " in " + className + ".");
        } else {
            if (student == null) {
                Logger.log("Student " + studentId + " does not exist.");
            }
            if (classroom == null) {
                Logger.log("Classroom " + className + " does not exist.");
            }
        }
    }

    private void listStudentsInClassroom(String className) {
        Classroom classroom = classroomService.getClassroom(className);
        if (classroom != null) {
            List<Student> students = classroom.getStudents();
            if (students.isEmpty()) {
                System.out.println("No students in " + className + ".");
            } else {
                System.out.println("Students in " + className + ":");
                students.forEach(student -> System.out.println(student.getId()));
            }
        } else {
            Logger.log("Classroom " + className + " does not exist.");
        }
    }

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        manager.start();
    }
}
