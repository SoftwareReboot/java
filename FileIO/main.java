package fileIOprac;

import java.util.*;

public class main {
    public static void main(String[] args) {
        StudentGradeSystem sgs = new StudentGradeSystem();
        Scanner scann = new Scanner(System.in);
        int choice;

        try {
            do{
                System.out.println("\n========= Student Grade System =========");
                System.out.println("1. Add Student Name's and Grade");
                System.out.println("2. View Students");
                System.out.println("3. Update Students Grade");
                System.out.println("4. Delete Students");
                System.out.println("5. Exit");
                System.out.println("=============================================");
                System.out.print(" Enter Your Choice: ");
    
                choice = scann.nextInt();
                scann.nextLine();
                
                    switch (choice) {
                        case 1:
                            System.out.println(" Enter Student Name: ");
                            String ns = scann.nextLine();
                            System.out.println(" Enter Grade: ");
                            String gr = scann.nextLine();
                            sgs.addStudent(ns, gr);
                            break;
                        case 2:
                            sgs.viewStudents();
                            break;
                        case 3:
                            System.out.println(" Enter students name to update: ");
                            String oldName = scann.nextLine();
                            System.out.println(" Enter new Grade: ");
                            String newGrade = scann.nextLine();
                            sgs.updateStudentGrade(oldName, newGrade);
                            break;
                        case 4:
                            System.out.println(" Enter student name to delete: ");
                            String nameToDelete = scann.nextLine();
                            sgs.deleteStudentInfo(nameToDelete);
                            break;
                        case 5:
                            System.out.println(" Exiting System...");
                            break;
                    
                        default:
                            System.out.println(" Invalid Choice., Try Again.");
                            break;
                    }
            }while( choice != 5);
        } catch (InputMismatchException e) {
            System.out.println(" Please Enter valid Choice.");
        }finally{
            scann.close();
        }
    }
}
