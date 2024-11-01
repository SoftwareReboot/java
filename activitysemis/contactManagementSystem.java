package activitysemis;
import java.io.*;
import java.util.*;

public class contactManagementSystem {
    private static final String FILE_NAME = "C:\\Users\\Joseph\\Desktop\\Contacts.txt";

    // Method to add a contact
    public void addContacts(String name) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(name);
            bw.newLine();
            System.out.println(name + " successfully added to contacts.");
        } catch (IOException e) {
            System.out.println("Error in adding contacts: " + e.getMessage());
        }
    }

    // Method to view contacts and display contact count
    public void viewContacts() {
        ArrayList<String> viewContacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String contact;
            while ((contact = br.readLine()) != null) {
                viewContacts.add(contact);
            }

            System.out.println("\nTotal Contacts: " + viewContacts.size());
            if (viewContacts.isEmpty()) {
                System.out.println("Contacts not found.");
            } else {
                System.out.println("Contacts:");
                for (String contactName : viewContacts) {
                    System.out.println(contactName);
                }
            }
        } catch (IOException e) {
            System.out.println("Error in viewing contacts: " + e.getMessage());
        }
    }

    // Method to update contacts
    public void updateContacts(String oldName, String newName) {
        ArrayList<String> contacts = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String contact;
            while ((contact = br.readLine()) != null) {
                if (contact.equalsIgnoreCase(oldName)) {
                    contacts.add(newName);
                    found = true;
                } else {
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.out.println("Error in updating contacts: " + e.getMessage());
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String contact : contacts) {
                    bw.write(contact);
                    bw.newLine();
                }
                System.out.println("Contact updated successfully.");
            } catch (IOException e) {
                System.out.println("Error in updating contacts: " + e.getMessage());
            }
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Method to delete a contact
    public void deleteContacts(String deleteContact) {
        ArrayList<String> contacts = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String contact;
            while ((contact = br.readLine()) != null) {
                if (contact.equalsIgnoreCase(deleteContact)) {
                    found = true;
                } else {
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.out.println("Error in deleting contact: " + e.getMessage());
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String contact : contacts) {
                    bw.write(contact);
                    bw.newLine();
                }
                System.out.println("Contact deleted successfully.");
            } catch (IOException e) {
                System.out.println("Error in deleting contacts: " + e.getMessage());
            }
        } else {
            System.out.println("Contact not found.");
        }
    }
}
