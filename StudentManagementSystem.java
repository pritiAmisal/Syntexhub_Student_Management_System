import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println(id + "\t" + name + "\t" + age + "\t" + course);
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM ");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        studentList.add(new Student(id, name, age, course));
        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }

        System.out.println("\nID\tName\tAge\tCourse");
        System.out.println("----------------------------");
        for (Student s : studentList) {
            s.display();
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();

        for (Student s : studentList) {
            if (s.id == id) {
                sc.nextLine();
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        Iterator<Student> itr = studentList.iterator();
        while (itr.hasNext()) {
            if (itr.next().id == id) {
                itr.remove();
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }
}