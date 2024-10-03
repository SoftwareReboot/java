import java.util.*;

public class arraylistPrac2 {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int choice;
        ArrayList<String> students = new ArrayList<>();

            try {
                do{
                    System.out.println("------Student Class List---------------------------");
                    System.out.println(" Press [1] to add Students to Classlist.");
                    System.out.println(" Press [2] to remove Students from Classlist");
                    System.out.println(" Press [3] to Display Students From Classlist");
                    System.out.println(" Press [4] to Clear Student ClassList");
                    System.out.println(" Press [5] to Exit the Program");
                    System.out.println("----------------------------------------------------------");
        
                    System.out.print(" Enter your choice: ");
                    choice = scann.nextInt();
                    scann.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.print(" Enter Student Name to be added to the Class List: ");
                                String studenname = scann.nextLine();
                                students.add(studenname);
                                System.out.println(studenname + " Successfully added to Class List.");
                                break;
                            case 2:
                                System.out.println(" Enter Student Name to be remove to the Class List.");
                                studenname = scann.nextLine();
                                students.remove(studenname);
                                break;
                            case 3:
                                if (students.size() == 0) {
                                    System.out.println(" Class List is Empty.");
                                }else{
                                    System.out.println(" Students Class Lists: ");
                                    for(int i = 0; i < students.size(); i++){
                                        System.out.println(students.get(i));
                                    }
                                }
                                break;
                            case 4:
                                students.clear();
                                System.out.println(" Class list is Empty.");
                            case 5:
                                System.out.println(" Program successfully Terminated");
                            default:
                                System.out.println(" Invalid Choice Try again.");
                                break;
                        }
                }while(choice != 5);
            } catch (InputMismatchException e) {
               System.out.println(" Error, please input Students Name.");
            }finally{
                scann.close();
                System.out.println(" Program Executed Successfully.");
            }
        }    
    }
