import java.util.regex.Pattern;

public class Student {
    private String name;
    private String email;
    private Major major;
    private String age;
    private String studentNum;

    public Student(String name, String studentNum, String email, Major major, String age) {
        setName(name);
        setStudentNum(studentNum);
        setEmail(email);
        setMajor(major);
        setAge(age);
    }


    public void setStudentNum(String studentNum) {
        if (Pattern.matches("[0-9]{3,}",studentNum)){
            this.studentNum = studentNum;
        } else {
            throw new IllegalArgumentException("invalid student number");
        }
    }
    public void setName(String name) {
        if (Pattern.matches("[a-zA-Z]{3,}",name)){
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("invalid name");
        }
    }

    public void setEmail(String email) {
        if (Pattern.matches("^[A-Za-z0-9._%+-]+@email\\.com$",email)){
            this.email = email;
        } else {
            throw new IllegalArgumentException("invalid email");
        }
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public void setAge(String age) {
        if (Pattern.matches("[0-9]+",age)){
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

    public String getAge() {
        return age;
    }
    public String getStudentNum() {
        return studentNum;
    }

    @Override
    public String toString() {
        return
                "\tname='" + name  + "\n" +
                "\temail='" + email + "'\n" +
                "\tmajor='" + major + "'\n" +
                "\tage='" + age + "'\n" +
                "\tstudentNum='" + studentNum + "'";
    }
}
