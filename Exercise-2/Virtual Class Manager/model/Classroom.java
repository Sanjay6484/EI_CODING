package model;

import java.util.*;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<String> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void scheduleAssignment(String assignment) {
        assignments.add(assignment);
    }

    public List<String> getAssignments() {
        return assignments;
    }
}
