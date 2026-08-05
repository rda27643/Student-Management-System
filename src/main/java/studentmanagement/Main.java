package studentmanagement;

import studentmanagement.model.Major;
import studentmanagement.model.Student;
import studentmanagement.service.StudentManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner sc = new Scanner(System.in);
        int choice, majorId,age;
        String name, studNumber, email,temp;
        Student student;
        Major major;
        boolean flag;
        end:
        while (true) {
            displayMenu();
            System.out.print("Choice: ");
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("invalid choice please enter number\n");
                sc.nextLine();
                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.println("\n-------------");
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Student Number: ");
                    studNumber = sc.nextLine();
                    System.out.print("Enter age: ");
                    try {
                        age = sc.nextInt();
                    } catch (Exception e){
                        System.out.println("Invalid age format");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    System.out.print("Enter email ( example@email.com ) : ");
                    email = sc.nextLine();
                    System.out.println("major list : ");
                    for (Major m : Major.values()) {
                        System.out.println(m.getMajorId() + "- " + m.getLabel());
                    }
                    System.out.print("Enter number of major: ");
                    temp = sc.nextLine();
                    if (temp.matches("[12345678]")){
                        majorId = Integer.parseInt(temp);
                    } else {
                        System.out.println("\nInvalid choice try again\n");
                        continue;
                    }
                    major = Major.findMajor(majorId);
                    if (major == null) {
                        System.out.println("Not found major id");
                        continue;
                    }
                    try {
                        student = new Student(name, studNumber, email, major, age);
                        flag = studentManagement.addStudent(student);
                        if (flag){
                            System.out.println("Student added successfully");
                        } else {
                            System.out.println("Student already exists");
                        }

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
                    System.out.print("Enter the id: ");
                    studNumber = sc.nextLine();
                    student = studentManagement.searchStudent(studNumber);
                    if (student == null){
                        System.out.println("Not found student");
                        continue;
                    }
                    System.out.println("Student:\n" + student);
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
                    try {
                        age = sc.nextInt();
                    } catch (Exception e){
                        System.out.println("Invalid age format");
                        sc.nextLine();
                        continue;
                    }
                    sc.nextLine();
                    try {
                        flag = studentManagement.editStudent(name, studNumber, email, age);
                        if (!flag){
                            System.out.println("Student not found");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                }
                case 5 -> {
                    System.out.println("-------------");
                    System.out.print("Enter student number for delete: ");
                    studNumber = sc.nextLine();
                    flag = studentManagement.deleteStudent(studNumber);
                    if (flag){
                        System.out.println("Delete done");
                    }else
                        System.out.println("Student not found");

                }
                case 6 -> {
                    System.out.println("Exit program....");
                    break end;
                }
                default -> {
                    System.out.println("invalid choice try again!");
                    continue;
                }
            }

            System.out.println("-------------\n");

        }

    }

    public static void displayMenu() {
        String[] menu = {"Add Student", "Show all Students", "Search Student", "Edit Student", "Delete Student", "Exit"};
        int counter = 1;
        System.out.println("====================");
        System.out.println("  Student Management");
        System.out.println("====================");
        for (String s : menu) {
            System.out.println(counter++ + ". " + s);
        }
        System.out.println("====================");
    }
}
