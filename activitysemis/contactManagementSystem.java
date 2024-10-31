package activitysemis;
import java.io.*;
import java.util.*;
public class contactManagementSystem {
    private static final String FILE_NAME = "C:\\Users\\Joseph\\Desktop\\contacts.txt";

    //method to add an contact
    public void addContacts(String name){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            bw.write(name);
            bw.newLine();
            System.out.println(name + " Successfully added to Contacts.");
        }catch(IOException e){
            System.out.println(" Error in Adding Contacts" + e.getMessage());
        }
        
    }

    //method to view Contacts
    public void viewContacts(){
        
        ArrayList<String> viewContacts = new ArrayList<>();
       
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String contact;
            System.out.println(" Contacts: ");
            while((contact = br.readLine()) != null){
                viewContacts.add(contact);
            }

            if (viewContacts.isEmpty()) {
                System.out.println(" Contacts not Found/");
            }else{
               for(int i = 0; i < viewContacts.size(); i++){
                    System.out.println(viewContacts.get(i));
               }
            }
        } catch (IOException e) {
            System.out.println(" Error in viewing Contacts: " + e.getMessage());
        }
    }

    //method to Update Contacts
    public void updateContacts(String oldName, String newName){
        ArrayList<String> contacts = new ArrayList<>();// arraylist para mo store sa contacts(Temporary)
        boolean found = false; // boolean pra mo check kong ang contact na e update kay na kit_an

        //mo read siya sa  contacts from file and check kong  oldName kay ni exists
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String contact;
            while ((contact = br.readLine()) != null) {
                //if contacts matches old name replace it to new name
                if (contact.equalsIgnoreCase(oldName)) {
                    contacts.add(newName);
                    found = true; // set true since we found the contact
                }else{
                    contacts.add(contact);//add other contacts unchanged
                }
            }
        } catch (IOException e) {
            System.out.println(" Error in Updating Contacts: " + e.getMessage());
        }

         // If the contact was found, write the updated list back to the file
         if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for(int i = 0; i < contacts.size(); i ++){
                    bw.write(contacts.get(i));
                    bw.newLine();
                }
                System.out.println(" Contact Updated Successfully.");
            } catch (IOException e) {
                System.out.println(" Error In Updating Contacts: " + e.getMessage());            
            }
        }else{
            System.out.println(" Contact not Found.");
        }
    }

    //method to delete an contact
    public void deleteContacts(String deleteContact){
        ArrayList<String> contacts = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String contact;
            while ((contact = br.readLine()) != null) {
                if (contact.equalsIgnoreCase(deleteContact)) {
                    found = true;
                }else{
                    contacts.add(contact);
                }

            }
        } catch (IOException e) {
            System.out.println(" Error in Deleting Contact: " + e.getMessage());
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for(int i = 0; i < contacts.size(); i++){
                    bw.write(contacts.get(i));
                    bw.newLine();
                }
                System.out.println(" Contact Deleted Successfuly.");
            } catch (IOException e) {
                System.out.println(" Error in Deleting Contacts: " + e.getMessage());
            }
        }else{
            System.out.println(" Contact not Found.");
        }
    }
}


