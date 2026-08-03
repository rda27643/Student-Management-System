import java.util.regex.Pattern;

public class Student {
    private String name;
    private String email;
    private Major major;
    private String age;
    private final String id;
    private static int counter = 0;

    public Student(String name, String email, Major major, String age) {
        this.id = "405" + counter++;
        setName(name);
        setEmail(email);
        setMajor(major);
        setAge(age);
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

    public String getId() {
        return id;
    }
}
