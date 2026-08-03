public class Student {
    private String name;
    private String email;
    private Major major;
    private String age;
    private String id;
    private static int counter = 0;

    public Student(String name, String email, Major major, String age) {
        this.id = "405" + counter++;
        this.name = setName(name);
        this.email = setEmail(email);
        this.major = setMajor(major);
        this.age = setAge(age);
    }
}
