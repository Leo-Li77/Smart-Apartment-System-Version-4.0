package com.leoli.Driver;

import com.leoli.FunctionStore.SuperDriver;
import com.leoli.Validations.Validation;


public class Driver extends SuperDriver {

    private Validation validation = new Validation();

    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        System.out.println(" Student Apartment System Version 3.0 ");
        System.out.println("--------------------------------------\n");

        Driver driver = new Driver();

    } // End of main()


    // The constructor of Driver Class
    Driver() {

        runMenu();

    }


    // Show the menu and get option from user.
    public int getOption() {

        System.out.print("""
                \033[34m\n--------------------
                 Operation Choosing
                --------------------
                0) Exit
                1) Add New Student and Start Project
                2) Start Project
                3) Update Project Status
                4) Display Your Projects
                5) Display Everyone's Projects
                6) Accommodation Agreement
                7) Sort StudentsID and Display Everyone's Projects
                8) Delete Student from List
                9) Search Student with Name\033[0m
                """);

        System.out.print("\033[34m[Enter the number of option to handle] \033[0m");
        String optionForTest = input.nextLine();
        while (!(validation.judgeIsInt(optionForTest))) {
            System.out.print("\033[34m[Please enter an integer option] \033[0m");
            optionForTest = input.nextLine();
        }
        int option =  Integer.parseInt(optionForTest);

        return option;

    } // End of GetOption()


    // Run methods depends on what option you get from your user.
    public void runMenu() {

        int option = getOption();
        if (option == 0) {
            System.out.println("\033[34m\n\nExiting Program...\033[0m\n");
        }
        while (option != 0) {
            switch (option) {
                case 1  ->  addAndStart();
                case 2  ->  startProject();
                case 3  ->  updateStatus();
                case 4  ->  displayPersonalProject();
                case 5  ->  displayAllProjects();
                case 6  ->  accommodationNotice();
                case 7  ->  sortStudentID();
                case 8  ->  deleteStudent();
                case 9  ->  searchStudentWithName();
                default ->  System.out.println("\033[34m<Invalid option. Try again.>\033[0m");
            }
            System.out.println("\033[34m\n<Press Enter to continue...>\033[0m");
            input.nextLine();
            option = getOption();
        }

    } // End of runMenu()

} // End of Driver Class