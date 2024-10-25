package com.company;
import java.util.*;


public class ERead{
        Scanner input = new Scanner(System.in);
        HashMap<String, Integer> student_info = new HashMap<>();
        HashMap<Integer, String> student_password = new HashMap<>();

        int [] books_id = new int[100];
        String [] books_name = new String[100];

        public void operations(int choice){
            if (choice == 1) {
                borrow();
            }
            else if (choice == 2) {
                Return();
            }
            else if (choice == 3){
                donate();
            }
            else if (choice == 4){
                scan();
            }
            else if (choice == 5){
                print();
            }
            else {
                System.out.println(" Wrong input!");
            }
        }
        public void books() {
            for(int i = 0; i < 5; i++) {
                books_id[i] = i+1;
            }
            books_name[0]= "Cinderella by Charles Perrault";
            books_name[1]="Sleeping Beauty by Giambattista Basile";
            books_name[2]="The Little Mermaid by Hans Christian Andersten";
            books_name[3]=" Ndabaga by Arnold Agaba";
            books_name[4]="Things Fall Apart by Chinua Achebe";
        }
        public void Register() {
            System.out.println("Enter student name:");
            String student_name = input.nextLine();
            System.out.println("Enter student id:");
            int student_id =input.nextInt();
            if (student_info.containsValue(student_id)) {
                    System.out.println("Already registered to system!");
                }
                else {
                    student_info.put(student_name, student_id);
                    System.out.println("Enter password (Minimum 8 characters):");
                    String password = input.next();
                    if (password.length() >= 8) {
                        student_password.put(student_id, password);
                        System.out.println("Registration successfully!");
                    }
                    else {
                        System.out.println("Enter valid password!");
                    }
                }
            }

        public void Login() {

            System.out.println("Enter student ID: ");
            int student_ID = input.nextInt();
            System.out.println("Enter password: ");
            String password = input.next();
            if(student_password.containsKey(student_ID))
                    if (student_password.get(student_ID).equals(password)) {
                        System.out.println("Press:");
                        System.out.println("       1- Borrow book");
                        System.out.println("       2- Return book");
                        System.out.println("       3- Donate");
                        System.out.println("       4- Scan copies");
                        System.out.println("       5- Print copies");
                        int choice = input.nextInt();
                        operations(choice);
                    }
            else {
                        System.out.println("Oops!Wrong password.");
                    }
            else {
                    System.out.println("Account doesn't exist.");
                }
            }
        public void borrow()  {

                System.out.println("Books Available:");
                for(int i = 0 ; i < 5; i++) {
                        System.out.println("Books id:" + books_id[i]);
                        System.out.println("Books name:" + books_name[i]);
                    }
                System.out.println("Enter book id:");
                int book_id = input.nextInt();
                boolean state = false;
                for (int j : books_id) {
                if (book_id == j) {
                    System.out.println("Borrowed Successfully!");
                    state = true;
                }
            }
                if(!state) {
                    System.out.println("Enter valid book id!");
                }
            }

        public void Return(){
            System.out.println("Enter book id:");
            int book_id = input.nextInt();
            boolean state = false;
            for (int j : books_id) {
                if (book_id == j) {
                    System.out.println("Returned Successfully!");
                }
            }
            if(!state) {
                System.out.println("Enter valid book id!");
            }
        }

        public void donate() {
            System.out.println("Enter amount of donation:");
            int donate = input.nextInt();
            System.out.println("Received donation of "+ donate + " successfully!");
        }

        public void scan() {
            System.out.println("Enter number of copies:");
            int num_copies = input.nextInt();
            System.out.println("Enter amount:");
            int money = input.nextInt();
            int price = 10;  // currency in cedis
            int expected_amount, balance;
            expected_amount = price * num_copies;
            if (expected_amount == money) {
                System.out.println("Scanning successful! Please retrieve copies from scanner!");
            }
            else if(expected_amount < money) {
                balance = money - expected_amount;
                System.out.println("Scanning successful! Please retrieve copies from scanner!");
                System.out.println("Expected Balance:" + balance);
            }
            else {
                System.out.println("Insufficient funds! Please recharge your account!");
            }


        }
        public void print() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number of copies:");
            int num_copies = input.nextInt();
            System.out.println("Enter amount:");
            int money = input.nextInt();
            int price = 10;  // currency in cedis
            int expected_amount, balance;
            expected_amount = price * num_copies;
            if (expected_amount == money) {
                System.out.println("Printing successful! Please retrieve copies from printer!");
            }
            else if(expected_amount < money) {
                balance = money - expected_amount;
                System.out.println("Printing successful! Please retrieve copies from printer!");
                System.out.println("Expected Balance:" + balance);
            }
            else {
                System.out.println("Insufficient funds! Please recharge your account!");
            }
        }

    public static void main(String[] args){
	    ERead service = new ERead();
        service.books();
        service.Register();
        System.out.println("Logging in");
        service.Login();






    }
}
