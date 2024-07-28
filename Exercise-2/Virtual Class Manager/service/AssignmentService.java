package service;

import model.Classroom;
import model.Student;
import util.Logger;

public class AssignmentService {
    public void scheduleAssignment(Classroom classroom, String assignment) {
        if (classroom == null) {
            Logger.log("Classroom does not exist.");
            return;
        }
        classroom.scheduleAssignment(assignment);
        Logger.log("Assignment for " + classroom.getName() + " has been scheduled.");
    }

    public void submitAssignment(Student student, Classroom classroom, String assignment) {
        if (classroom == null) {
            Logger.log("Classroom does not exist.");
            return;
        }
        if (student == null) {
            Logger.log("Student does not exist.");
            return;
        }
        student.submitAssignment(classroom.getName(), assignment);
        Logger.log("Assignment submitted by Student " + student.getId() + " in " + classroom.getName() + ".");
    }
}
