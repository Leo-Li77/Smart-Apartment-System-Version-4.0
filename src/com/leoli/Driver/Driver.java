package com.leoli.Driver;

import com.leoli.FunctionStore.SuperDriver;
import com.leoli.Validations.Validation;
import com.leoli.FunctionStore.ColorStore;


public class Driver extends SuperDriver {

    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        System.out.println(" Student Apartment System-Version 4.0 ");
        System.out.println("--------------------------------------\n");

        Driver driver = new Driver();


    } // End of main()


    // The constructor of Driver Class
    Driver() {

        runMenu();

    }


    // Show the menu and get option from user.
    public int getOption() {

        System.out.print(colorStore.blue("""
                \n\n\n--------------------
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
                9) Search Student with Name
                """));

        int option = 1;
        System.out.print(colorStore.blue("[Enter option to handle] "));
        while (true) {
            String optionForTest = input.nextLine();

            if (!validation.judgeIsInt(optionForTest)) {
                System.out.print(colorStore.red("[Please enter a integer option] "));
                continue;
            }

            option = Integer.parseInt(optionForTest);

            if (option < 0 || option > 9) {
                System.out.print(colorStore.red("[Please enter an option between 1 and 9] "));
                continue;
            }

            break;
        }

        return option;

    } // End of GetOption()


    // Run methods depends on what option you get from your user.
    public void runMenu() {

        int option = getOption();
        if (option == 0) {
            System.out.println(colorStore.blue("\n\nExiting Program...\n"));
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
            }
//            System.out.println(colorStore.blue("\n<Press Enter to continue...>"));
//            input.nextLine();
            option = getOption();
        }

    } // End of runMenu()

} // End of Driver Class