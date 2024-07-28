package service;
import model.Classroom;
import java.util.ArrayList;
import java.util.List;

public class ClassroomService {
    private List<Classroom> classrooms;

    public ClassroomService() {
        this.classrooms = new ArrayList<>();
    }

    public void addClassroom(String name) {
        classrooms.add(new Classroom(name));
    }

    public boolean removeClassroom(String name) {
        return classrooms.removeIf(classroom -> classroom.getName().equals(name));
    }

    public List<Classroom> getAllClassrooms() {
        return new ArrayList<>(classrooms);
    }

    public Classroom getClassroom(String name) {
        return classrooms.stream()
                         .filter(classroom -> classroom.getName().equals(name))
                         .findFirst()
                         .orElse(null);
    }
}
