package Assignment1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class AddressBook {

    public static class Contact {
        private String name;
        private String email;
        private String phone;
        private String notes;
        private int id;
    
        public String getName() {
            return name;
        }
        public void setName(String newName) {
            name = newName;
        }
    
        public String getEmail() {
            return email;
        }
        public void setEmail(String newEmail) {
            email = newEmail;
        }
    
        public String getPhone() {
            return phone;
        }
        public void setPhone(String newPhone) {
            phone = newPhone;
        }
    
        public String getNotes() {
            return notes;
        }
        public void setNotes(String newNotes) {
            notes = newNotes;
        }

        public int getId() {
            return id;
        }
        public void setId(int newId) {
            id = newId;
        }
    }
    public static void main(String[] args) {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        displayMenu(contactList);
        System.out.println("\nGoodbye!\n");
    }

    ///////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////////////

    public static void displayMenu(ArrayList<Contact> contactList) {

        Scanner in = new Scanner(System.in);

        System.out.println("Main");
        System.out.println("=============");
        System.out.println("Choose one of the following  options:");
        System.out.println("(1) Add a new contact.");
        System.out.println("(2) Search for contact.");
        System.out.println("(3) Display all contacts.");
        System.out.println("(4) Quit");
        System.out.println("Enter your choice: ");

        int choice = in.nextInt();
        in.nextLine();

        switch(choice) {
            case 1:
                addContact(contactList, in);
                displayMenu(contactList);
                break;

            case 2:
                System.out.printf("Size of list: %d\n", contactList.size());
                searchContact(contactList, in);
                displayMenu(contactList);
                break;

            case 3:
                displayAllContacts(contactList, in);
                displayMenu(contactList);
                break;

            case 4:
                break;
            
            default:
                displayMenu(contactList);
                break;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////////////
    
    ///////////////////////////////////////////////////////////////////////////////////

    public static void addContact(ArrayList<Contact> contactList, Scanner in) {
        System.out.println("\nMain Window --> Add New Contact Window: (Enter the following information)");
        System.out.println("=======================================");
        System.out.println("Name");
        String newName = in.nextLine();
        System.out.println("Email: ");
        String newEmail = in.nextLine();
        System.out.println("Phone: ");
        String newPhone = in.nextLine();
        System.out.println("Notes: ");
        String newNotes = in.nextLine();
        System.out.println("---------------------------------------");
        System.out.println("Saved successfully....Press Enter to go back to the Main Window.");
        in.nextLine();
        System.out.println();

        Contact contact = new Contact();
        contact.setName(newName);
        contact.setEmail(newEmail);
        contact.setPhone(newPhone);
        contact.setNotes(newNotes);
        if (contactList.size() == 0) {
            contact.setId(1);
        } else {
            contact.setId(contactList.get(contactList.size()-1).getId()+1);
        }  contactList.add(contact);
        // System.out.println(contactList.get(0).getPhone());
    }

    public static void searchContact(ArrayList<Contact> contactList, Scanner in) {
        boolean contactFound = false;

        System.out.println("\nMain Window --> Search for Contact Window: (Enter the following information)");
        System.out.println("=======================================");
        System.out.println("(1) Search by Name");
        System.out.println("(2) Search by Email");
        System.out.println("(3) Search by Phone");
        System.out.println("\nEnter Your Choice:");
        String choice = in.nextLine();

        switch (Integer.parseInt(choice)) {
            case 1:
                System.out.println("\nMain Window --> Search for Contact Window --> Search by Name");
                System.out.println("=======================================");
                System.out.println("(1) Search by Name");
                String name = in.nextLine();
                System.out.println();
                // System.out.println(contactList.size());
                for (Contact contact : contactList) {
                    // System.out.println("looping");
                    // System.out.println(contact.getName());
                    if (contact.getName().equals(name)) {
                        displayContact(contact, contact.getId());
                        contactFound = true;
                    } else {
                        contactFound = false;
                    }
                }
                break;

            case 2:
                System.out.println("\nMain Window --> Search for Contact Window --> Search by Email");
                System.out.println("=======================================");
                System.out.println("(2) Search by Email");
                String email = in.nextLine();
                System.out.println();
                // System.out.println(contactList.size());
                for (Contact contact : contactList) {
                    // System.out.println("looping");
                    // System.out.println(contact.getName());
                    if (contact.getEmail().equals(email)) {
                        displayContact(contact, contact.getId());
                        contactFound = true;
                    } else {
                        contactFound = false;
                    }
                }
                break;

            case 3:
                System.out.println("\nMain Window --> Search for Contact Window --> Search by Phone");
                System.out.println("=======================================");
                System.out.println("(3) Search by Phone");
                String phone = in.nextLine();
                System.out.println();
                // System.out.println(contactList.size());
                for (Contact contact : contactList) {
                    // System.out.println("looping");
                    // System.out.println(contact.getName());
                    if (contact.getPhone().equals(phone)) {
                        displayContact(contact, contact.getId());
                        contactFound = true;
                    } else {
                        contactFound = false;
                    }
                }
                break;
        
            default:
                searchContact(contactList, in);
                break;
        }
        if (contactFound) {
            System.out.println("Choose on of these options: ");
            System.out.println("(1) To delete a contact.");
            System.out.println("(2) Back to main window.");
            System.out.printf("Option: ");
            choice = in.nextLine();
            switch (Integer.parseInt(choice)) {
                case 1:
                    System.out.printf("Enter the ID of the contact that you would like to delete: ");
                    String selectedContactId = in.nextLine();
                    int id = Integer.parseInt(selectedContactId);
                    deleteContact(contactList, id);
                    System.out.println("Contact successfully deleted.");
                    break;

                case 2:
                    break;
            
                default:
                    break;
            }
        } else {
            System.out.println("No contact was found with provided information.");
        }
        System.out.println("Press Enter to go back to the Main Window.");
        in.nextLine();
        System.out.println();
    }

    public static void displayAllContacts(ArrayList<Contact> contactList, Scanner in) {
        ArrayList<Contact> tempList = contactList;
        for (int i = 0; i < tempList.size()-1; i++) {
            for (int j = 1; j < tempList.size()-1; j++) {
                if (tempList.get(i).getName().compareTo(tempList.get(j).getName()) > 0) {
                    System.out.printf("Swapping: %s, %s", tempList.get(i).getName(), tempList.get(j).getName());
                    Collections.swap(tempList, i, j);
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("ID | Name\t| Email\t| Phone\t| Notes\n");
        for (Contact contact : tempList) {
            displayContact(contact, contact.getId());
        }
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Press Enter to go back to the Main Window.");
        in.nextLine();
        System.out.println();
    }

    public static void deleteContact(ArrayList<Contact> contactList, int id) {
        for (Contact contact : contactList) {
            if (contact.getId() == id) {
                contactList.remove(contact);
                break;
            }
        }
    }

    public static void displayContact(Contact contact, int id) {
        // System.out.printf("From displayContact(): %s", contact.getName());
        System.out.printf("%d  | %s\t| %s\t| %s\t| %s\n", id, contact.getName(), contact.getEmail(), contact.getPhone(), contact.getNotes());
    }
}