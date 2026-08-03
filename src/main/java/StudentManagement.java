import java.util.HashMap;
import java.util.Map;

public class StudentManagement {
    private final HashMap<String,Student> students;

    public StudentManagement() {
        this.students = new HashMap<>();
    }
    public void addStudent(Student student){
        if (students.putIfAbsent(student.getStudentNum(),student) == null){
            System.out.println("add successfully");
        } else {
            System.out.println("wrong input");
        }

    }
    public void showAllStudents(){
        int counter = 0;
        for (Map.Entry<String, Student> i : students.entrySet()) {
            System.out.println("S " + counter + ":");
            System.out.println(i.getValue());
        }
    }
}
