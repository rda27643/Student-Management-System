import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public void showAllStudents(){
        int count = 0;
        if (students.isEmpty()){
            System.out.println("no student for show!");
        } else {
            for (Student s : students) {
                System.out.println("S" + count++);
                System.out.println("\t" + s);
            }
        }
    }
}
