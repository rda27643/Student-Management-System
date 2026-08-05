import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        int choice, majorId;
        String name, studNumber, email, age;
        Student s;
        Major major;
        while (true) {
            displayMenu();
            System.out.print("Choice: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("invalid choice please enter number\n");
                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("-------------");
                    System.out.println("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Student Number: ");
                    studNumber = sc.nextLine();
                    System.out.print("Enter age: ");
                    age = sc.nextLine();
                    System.out.print("Enter email ( example@email.com )");
                    email = sc.nextLine();
                    System.out.println("major list : ");
                    int counter = 1;
                    for (Major m : Major.values()) {
                        System.out.println(counter++ + "- " + m);
                    }
                    System.out.print("Enter number of major: ");
                    majorId = sc.nextInt();
                    sc.nextLine();
                    major = Major.findMajor(majorId);
                    if (major == null) {
                        System.out.println("Not found major id");
                        continue;
                    }
                    try {
                        s = new Student(name, studNumber, email, major, age);
                        studentManagement.addStudent(s);

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("-------------");
                    studentManagement.showAllStudents();
                }
                case 3 -> {
                    System.out.println("-------------");
                    System.out.print("Enter the id ");
                    studNumber = sc.nextLine();
                    System.out.println("Student:\n" + studentManagement.searchStudent(studNumber));
                }
                case 4 -> {
                    System.out.println("-------------");
                    System.out.print("Enter Student Number you want edit: ");
                    studNumber = sc.nextLine();
                    System.out.println("Enter new info:");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("email: ");
                    email = sc.nextLine();
                    System.out.print("age: ");
                    age = sc.nextLine();
                    try {
                        studentManagement.editStudent(name, studNumber, email, age);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 5 -> {
                    System.out.println("-------------");
                    System.out.print("Enter student number for delete: ");
                    studNumber = sc.nextLine();
                    studentManagement.deleteStudent(studNumber);

                }
            }
            System.out.println("-------------");

        }

    }

    public static void displayMenu() {
        String[] menu = {"Add Student", "Show Student", "Search Student", "Edit Student", "Delete Student", "Exit"};
        int counter = 1;
        System.out.println("====== Menu ======");
        for (String s : menu) {
            System.out.println(counter++ + ". " + s);
        }
        System.out.println("============");
    }
}
