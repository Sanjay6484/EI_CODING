package service;

import model.Classroom;
import model.Student;
import util.*;

import java.util.*;

public class StudentService {
    private Map<String, Student> students;

    public StudentService() {
        this.students = new HashMap<>();
    }

    public void addStudent(String id, Classroom classroom) {
        if (classroom == null) {
            Logger.log("Classroom does not exist.");
            return;
        }
        Student student = students.computeIfAbsent(id, k -> new Student(id));
        classroom.addStudent(student);
        Logger.log("Student " + id + " has been enrolled in " + classroom.getName() + ".");
    }

    public Student getStudent(String id) {
        return students.get(id);
    }
}
