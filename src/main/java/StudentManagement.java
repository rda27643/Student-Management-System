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
            System.out.println("S " +counter + ":");
            System.out.println(i.getValue());
        }
    }
    public Student searchStudent(String studNumber){
        if (students.get(studNumber) == null){
            return null;
        } else {
            return students.get(studNumber);
        }
    }

    public void editStudent(String nameNew, String studentNum, String emailNew, String ageNew){
        Student s = students.get(studentNum);
        if (s == null){
            System.out.println("not found");
        }else {
            s.setName(nameNew);
            s.setEmail(emailNew);
            s.setAge(ageNew);
        }
    }

    public void deleteStudent(String studNumber){
        if (students.remove(studNumber) == null){
            System.out.println("not found");
        } else
            System.out.println("delete done");
    }

}