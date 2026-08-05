package studentmanagement.model;

import java.util.regex.Pattern;

public class Student {
    private String name;
    private String email;
    private Major major;
    private int age;
    private String studentNum;

    public Student(String name, String studentNum, String email, Major major, int age) {
        setName(name);
        setStudentNum(studentNum);
        setEmail(email);
        setMajor(major);
        setAge(age);
    }


    public void setStudentNum(String studentNum) {
        if (Pattern.matches("\\d{8}", studentNum)) {
            this.studentNum = studentNum;
        } else {
            throw new IllegalArgumentException("Student number must contain exactly 8 digits");
        }
    }

    public void setName(String name) {
        if (Pattern.matches("^[a-zA-Z- ]{3,}$", name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("invalid name");
        }
    }

    public void setEmail(String email) {
        if (Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9-]+\\.[A-Za-z]{2,}$", email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("invalid email");
        }
    }

    public void setMajor(Major major) {
        if (major == null){
            throw new IllegalArgumentException("Invalid major");
        } else {
            this.major = major;
        }
    }

    public void setAge(int age) {
        if (age >= 18 && age < 85) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("invalid age");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Major getMajor() {
        return major;
    }

    public int getAge() {
        return age;
    }

    public String getStudentNum() {
        return studentNum;
    }

    @Override
    public String toString() {
        return "Student{\n\tName:  " + name + "\n\tStudent Number: " + studentNum + "\n\tEmail: "
                + email + "\n\tMajor: " + major + "\n\tAge: " + age + "\n}";

    }
}
