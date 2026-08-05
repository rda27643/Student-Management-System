package studentmanagement.service;

import studentmanagement.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentManagement {
    private final Map<String, Student> students;

    public StudentManagement() {
        this.students = new HashMap<>();
    }

    public boolean addStudent(Student student) {
        return students.putIfAbsent(student.getStudentNum(), student) == null;

    }

    public void showAllStudents() {
        if (students.isEmpty()){
            System.out.println("No student found");
            return;
        }
        int counter = 1;
        for (Map.Entry<String, Student> i : students.entrySet()) {
            System.out.println("------------------");
            System.out.println("Student " + counter++);
            System.out.println("------------------");
            System.out.println(i.getValue());
        }
    }

    public Student searchStudent(String studNumber) {
        return students.get(studNumber);
    }

    public boolean editStudent(String nameNew, String studentNum, String emailNew, int ageNew) {
        Student student = students.get(studentNum);
        if (student == null) {
            return false;
        } else {
            student.setName(nameNew);
            student.setEmail(emailNew);
            student.setAge(ageNew);
            return true;
        }
    }

    public boolean deleteStudent(String studNumber) {
        return students.remove(studNumber) != null;
    }

}