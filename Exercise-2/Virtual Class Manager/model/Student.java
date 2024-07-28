package model;

import java.util.*;

public class Student {
    private String id;
    private Map<String, List<String>> submittedAssignments;

    public Student(String id) {
        this.id = id;
        this.submittedAssignments = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void submitAssignment(String className, String assignment) {
        submittedAssignments.computeIfAbsent(className, k -> new ArrayList<>()).add(assignment);
    }

    public Map<String, List<String>> getSubmittedAssignments() {
        return submittedAssignments;
    }
}
