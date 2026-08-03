import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
}
