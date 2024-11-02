package fileIOprac;

import java.util.*;
import java.io.*;

public class StudentGradeSystem {
    private static final String FILE_NAME = "C:\\Users\\Joseph\\Desktop\\StudentGrades.txt";
    
    // Method to add a new student with grade
    public void addStudent(String name, String grade) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(name + "," + grade);
            bw.newLine();
            System.out.println("Successfully added: " + name + " | Grade: " + grade);
        } catch (IOException e) {
            System.out.println("Error in adding student: " + e.getMessage());
        }
    }

    // Method to view all students and their grades
    public void viewStudents() {
        ArrayList<String> studentInfo = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String info;
            while ((info = br.readLine()) != null) {
                studentInfo.add(info);
            }

            System.out.println("\nNumber of Students: " + studentInfo.size());
            if (studentInfo.isEmpty()) {
                System.out.println("No students found.");
            } else {
                System.out.println("Student List:");
                for (int i = 0; i < studentInfo.size(); i++) {
                    String[] data = studentInfo.get(i).split(",");
                    System.out.println("Student: " + data[0] + " | Grade: " + data[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error in viewing students: " + e.getMessage());
        }
    }

    // Method to update a student's grade
    public void updateStudentGrade(String name, String newGrade) {
        List<String> students = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String student;
            while ((student = br.readLine()) != null) {
                String[] data = student.split(",");
                if (data[0].equalsIgnoreCase(name)) {
                    students.add(name + "," + newGrade);
                    found = true;
                } else {
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating student grade: " + e.getMessage());
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (int i = 0; i < students.size(); i++) {
                    bw.write(students.get(i));
                    bw.newLine();
                }
                System.out.println("Grade successfully updated for: " + name);
            } catch (IOException e) {
                System.out.println("Error writing updated data: " + e.getMessage());
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method to delete a student's information
    public void deleteStudentInfo(String name) {
        ArrayList<String> students = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String info;
            while ((info = br.readLine()) != null) {
                String[] data = info.split(",");
                if (!data[0].equalsIgnoreCase(name)) {
                    students.add(info);
                } else {
                    found = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (int i = 0; i < students.size(); i++) {
                    bw.write(students.get(i));
                    bw.newLine();
                }
                System.out.println("Successfully deleted: " + name);
            } catch (IOException e) {
                System.out.println("Error writing updated data: " + e.getMessage());
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}
