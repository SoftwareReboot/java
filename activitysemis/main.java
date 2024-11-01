package activitysemis;
import java.util.*;

public class main {
    public static void main(String[] args) {
        contactManagementSystem cms = new contactManagementSystem();
        Scanner scann = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n========= Contact Management System =========");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.println("=============================================");
            System.out.print(" Enter Your Choice: ");

            choice = scann.nextInt();
            scann.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println(" Enter Contact Name to add: ");
                        String nameToAdd = scann.nextLine();
                        cms.addContacts(nameToAdd);
                        break;
                    case 2:
                        cms.viewContacts();
                        break;
                    case 3:
                        System.out.println(" Enter Contact Name to Update: ");
                        String oldName = scann.nextLine();
                        System.out.println(" Enter the New name: ");
                        String newName = scann.nextLine();
                        cms.updateContacts(oldName, newName);
                        break;
                    case 4:
                        System.out.println(" Enter Contact Name to Delete: ");
                        String nameToDelete = scann.nextLine();
                        cms.deleteContacts(nameToDelete);
                        break;
                    case 5:
                        System.out.println(" Exiting Contact Management System...");
                        break;
                
                    default:
                        System.out.println(" Invalid Choice, please try again.");
                        break;
                }
        }while(choice != 5);
    }    
}
