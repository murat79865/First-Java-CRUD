
package com.murat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== STUDENT CRUD APPLICATION ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    running = false;
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        students.add(name);

        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        System.out.println("\n=== STUDENT LIST ===");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    static void updateStudent() {
        viewStudents();

        if (students.isEmpty()) {
            return;
        }

        System.out.print("Enter student number to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        System.out.print("Enter new student name: ");
        String newName = scanner.nextLine();

        students.set(index - 1, newName);

        System.out.println("Student updated successfully!");
    }

    static void deleteStudent() {
        viewStudents();

        if (students.isEmpty()) {
            return;
        }

        System.out.print("Enter student number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        students.remove(index - 1);

        System.out.println("Student deleted successfully!");
    }
}
