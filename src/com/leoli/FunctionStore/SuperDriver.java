package com.leoli.FunctionStore;

import java.util.Scanner;
import java.util.ArrayList;

import java.awt.Desktop;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import com.leoli.Student.StudentApartment;
import com.leoli.Validations.Validation;
import com.leoli.FunctionStore.Functions;

public class SuperDriver {

    // Fields
    ArrayList<StudentApartment> studentStore = new ArrayList<>();
    protected Scanner input = new Scanner(System.in);

    // Create an object of Validation Class to use the methods in it
    Validation validation = new Validation();
    Functions functions = new Functions();


    // The option 1 : Add New Student and Start Iterm
    protected void addAndStart() {

        System.out.println("\033[33m\n---------------\033[0m");
        System.out.println("\033[33m Start Project \033[0m");
        System.out.println("\033[33m---------------\033[0m");

        // input and validate the name
        System.out.print("\033[33m[Enter name]         \033[0m");
        String name = input.nextLine();
        while (!(validation.judgeName(name))) {
            System.out.print("\033[33m[Please enter a name longer than 2 words] \033[0m");
            name = input.nextLine();
        }

        // input and validate studentID
        System.out.print("\033[33m[Enter student ID]   \033[0m");
        String studentIDForTest = input.nextLine();
        while (!validation.judgeID(studentIDForTest) || !validation.judgeUniqueID(studentIDForTest, studentStore)) {
            if (!validation.judgeUniqueID(studentIDForTest, studentStore)) {
                System.out.print("\033[33m[This student ID is already registered] \033[0m");
                studentIDForTest = input.nextLine();
            } else {
                System.out.print("\033[33m[Student ID must be exactly 12 digits] \033[0m");
                studentIDForTest = input.nextLine();
            }
        }
        String studentID = studentIDForTest;

        // input and validate phone number
        System.out.print("\033[33m[Enter phone number] \033[0m");
        String phoneNumber = input.nextLine();
        while (!(validation.judgePhoneNumber(phoneNumber))) {
            System.out.print("\033[33m[Please enter a valid phone number] \033[0m");
            phoneNumber = input.nextLine();
        }

        StudentApartment newStudent = new StudentApartment(name, studentID, phoneNumber);
        studentStore.add(newStudent);

        System.out.print("""
                \033[33m-------------------------
                 Choose Project to Start
                -------------------------
                1) Accommodation Application
                2) Check-out Application
                3) Accommodation Transfer Application
                4) Apply Early
                5) Apply Late
                6) Item Borrowing Application
                7) Activity Room Borrowing Application
                8) Accommodation Notice\033[0m
                """);
        System.out.print("\033[33m[Enter your project number to start] \033[0m");
        String startProjectNumberForTest = input.nextLine();
        while (!validation.judgeIsInt(startProjectNumberForTest)) {
            System.out.print("\033[32m[Please enter an integer option] \033[0m");
            startProjectNumberForTest = input.nextLine();
        }
        int startProjectNumber = Integer.parseInt(startProjectNumberForTest);

        boolean flag1 = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                studentStore.get(i).iterms.set(startProjectNumber - 1, 1);
                flag1 = true;
                break;
            }
        }
        if (!flag1) {
            System.out.println("\033[33m<Please enter a valid student ID!>\033[0m");
        }

    } // End of AddAndStart


    // The option 2 : Start Project
    protected void startProject() {

        System.out.println("\033[32m\n---------------\033[0m");
        System.out.println("\033[32m Start Project \033[0m");
        System.out.println("\033[32m---------------\033[0m");

        if (studentStore.isEmpty()) {
            System.out.println("\033[32m<Before you choose other option, you should add a student at first (Option 1).>\033[0m");
        } else {

            System.out.print("\033[32m[Enter student ID to start project] \033[0m");
            String studentID = input.nextLine();
            while (!(validation.judgeID(studentID) || !validation.judgeIsLong(studentID))) {
                System.out.print("\033[32m[Please enter a valid student ID] \033[0m");
                studentID = input.nextLine();
            }

            System.out.print("""
                    \033[32m
                    -------------------------
                     Choose Project to Start
                    -------------------------
                    1) Accommodation Application
                    2) Check-out Application
                    3) Accommodation Transfer Application
                    4) Apply Early
                    5) Apply Late
                    6) Item Borrowing Application
                    7) Activity Room Borrowing Application
                    8) Accommodation Notice
                    \033[0m""");
            System.out.print("\033[32m[Enter your project number] \033[0m");
            String optionForTest = input.nextLine();
            while (!validation.judgeIsInt(optionForTest)) {
                System.out.print("\033[32m[Please enter an integer option] \033[0m");
                optionForTest = input.nextLine();
            }
            int option = Integer.parseInt(optionForTest);

            boolean flag = false;
            for (int i = 0; i < studentStore.size(); i++) {
                if (studentStore.get(i).getStudentID().equals(studentID)) {
                    studentStore.get(i).iterms.set(option - 1, 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("\033[32m<You have not been added to the student list yet!>\033[0m");
            }
        }
    } // End of StartProject()


    // The option 3 : Update Project Status
    protected void updateStatus() {

        System.out.println("\033[35m\n---------------\033[0m");
        System.out.println("\033[35m Update Status \033[0m");
        System.out.println("\033[35m---------------\033[0m");

        if (studentStore.isEmpty()) {
            System.out.println("\033[35m<Before you choose other option, you should add a student at first (Option 1).>\033[0m");
        } else {
            System.out.print("\033[35m[Enter your studentID] \033[0m");
            String studentID = input.nextLine();
            while (!(validation.judgeID(studentID) || !validation.judgeIsLong(studentID))) {
                System.out.print("\033[35m[Please enter a valid student ID] \033[0m");
                studentID = input.nextLine();
            }

            System.out.print("""
                    \033[35m--------------------------
                     Choose Project to Update
                    --------------------------
                    1) Accommodation Application
                    2) Check-out Application
                    3) Accommodation Transfer Application
                    4) Apply Early
                    5) Apply Late
                    6) Item Borrowing Application
                    7) Activity Room Borrowing Application
                    8) Accommodation Notice\033[0m
                    """);
            System.out.print("\033[35m[Enter your project number to update] \033[0m");
            String itermNumberForTest = input.nextLine();
            while (!validation.judgeIsInt(itermNumberForTest)) {
                System.out.print("\033[35m[Please enter an integer option] \033[0m");
                itermNumberForTest = input.nextLine();
            }
            int itermNumber = Integer.parseInt(itermNumberForTest);

            System.out.print("""
                    \n\033[35m----------------
                     Update Options
                    ----------------
                    1) Cancel the Application
                    2) Application Succeeded
                    3) Application Failed\033[0m
                    """);
            System.out.print("\033[35mEnter your update option] \033[0m");
            String optionNumberForTest = input.nextLine();
            while (!validation.judgeIsInt(optionNumberForTest)) {
                System.out.print("\033[35m[Please enter an integer option] \033[0m");
                optionNumberForTest = input.nextLine();
            }
            int option = Integer.parseInt(optionNumberForTest);

            boolean flag = false;
            for (int i = 0; i < studentStore.size(); i++) {
                if (studentStore.get(i).getStudentID().equals(studentID)) {
                    switch (option) {
                        case 1:
                            studentStore.get(i).cancelTerm(itermNumber - 1);
                            flag = true;
                            break;
                        case 2:
                            studentStore.get(i).applicationSuccess(itermNumber - 1);
                            flag = true;
                            break;
                        case 3:
                            studentStore.get(i).applicationFailed(itermNumber - 1);
                            flag = true;
                            break;
                        default:
                            System.out.println("\033[35m<Please enter a valid option!>\033[0m");
                            break;
                    }
                    break;
                }
            }
            if (!flag) {
                System.out.println("\033[35m<Please enter a valid project number!>\033[0m");
            }
        }
    } // End of UpdateStatus()


    // The option 4 : Display Your Projects
    protected void displayPersonalProject() {

        System.out.println("\033[36m\n---------------------------\033[0m");
        System.out.println("\033[36m Display Personal Projects \033[0m");
        System.out.println("\033[36m---------------------------\033[0m");
        if (studentStore.isEmpty()) {
            System.out.println("\033[36m<Before you choose other option, you should add a student at first (Option 1).>\033[0m");
        } else {
        System.out.print("\033[36m[Enter your studentID] \033[0m");
        String studentID = input.nextLine();
        while (studentID.length() != 12 || !validation.judgeIsLong(studentID)) {
            System.out.print("\033[36m[Please enter a valid student ID] \033[0m");
            studentID = input.nextLine();
        }

        boolean flag = false;
        for (int i = 0; i < studentStore.size(); i++) {
            if (studentStore.get(i).getStudentID().equals(studentID)) {
                System.out.println(studentStore.get(i));
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("\033[36m<Student ID does not exist!>\033[0m");
        }
}
    } // End of DisplayPersonalProject


    // The option 5 : Display Everyone's Projects
    protected void displayAllProjects() {

        System.out.println("\033[94m\n----------------------\033[0m");
        System.out.println("\033[94m Display All Projects \033[0m");
        System.out.println("\033[94m----------------------\033[0m");
        if (studentStore.isEmpty()) {
            System.out.println("\033[94m<Before you choose other option, you should add a student at first (Option 1).>\033[0m");
        } else {
                for (int i = 0; i < studentStore.size(); i++) {
                    System.out.println(studentStore.get(i));
                }
        }
    } // End of DisplayAllProjects


    // The option 6 : Accommodation Notice
    protected void accommodationNotice() {

        String resourcePath = "com/leoli/Files/Accomendation Notice.html";

        try (InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (resourceStream == null) {
                System.err.println("\033[91m❌ HTML resource not found in classpath: " + resourcePath + "\033[0m");
                return;
            }

            // 创建临时文件
            Path tempFile = Files.createTempFile("dormitory_agreement_", ".html");
            Files.copy(resourceStream, tempFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            // 自动用浏览器打开
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(tempFile.toUri());
                System.out.println("\033[96m✅ Dormitory agreement opened in browser.\033[0m");

                // 可选：程序退出时删除临时文件（但浏览器可能还在用，慎删）
                // tempFile.toFile().deleteOnExit();
            } else {
                System.out.println("\033[93m⚠️  Cannot open browser. File saved temporarily at: " + tempFile + "\033[0m");
            }

        } catch (IOException e) {
            System.err.println("\033[91m❌ Failed to open dormitory agreement: " + e.getMessage() + "\033[0m");
            e.printStackTrace();
        }

    }


    // The option 7 : (To Sort in Ascending Order by StudentID)
    protected void sortStudentID() {

        System.out.println("\033[94m\n------------------------------------------------\033[0m");
        System.out.println("\033[94m Sort StudentsID and Display Everyone's Projects \033[0m");
        System.out.println("\033[94m-------------------------------------------------\033[0m");

        if (studentStore.isEmpty()) {
            System.out.println("\033[94m<Before you choose other option, you should add a student at first (Option 1).>\033[0m");
        } else {
            int min;
            for (int i = 0; i < studentStore.size() - 1; i++) {
                min = i;
                for (int j = i + 1; j < studentStore.size(); j++) {
                    if (Long.parseLong(studentStore.get(j).getStudentID()) < Long.parseLong(studentStore.get(min).getStudentID())) {
                        min = j;
                    }
                }
                if (min != i) {
                    StudentApartment temp = studentStore.get(min);
                    studentStore.set(min, studentStore.get(i));
                    studentStore.set(i, temp);
                }
            }
            displayAllProjects();
        }
    } // End of sortStudentID


    // The option 8 : Delete Student from List
    protected void deleteStudent() {

        if (studentStore.isEmpty()) {
            System.out.println("\033[32m<Before you choose other option, you should add a student at first (Option 1).>\033[0m");
        } else {
            System.out.println("\033[35m\n----------------\033[0m");
            System.out.println("\033[35m Delete Student \033[0m");
            System.out.println("\033[35m----------------\033[0m");

            System.out.print("\033[35m[Enter studentID to delete] \033[0m");
            String studentID = input.nextLine();
            while (!(validation.judgeID(studentID))) {
                System.out.print("\033[35m[Please enter a valid student ID] \033[0m");
                studentID = input.nextLine();
            }

            boolean flag = false;
            for (int i = 0; i < studentStore.size(); i++) {
                if (studentStore.get(i).getStudentID().equals(studentID)) {
                    studentStore.remove(i);
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("\033[35m<Student Not Found!>\033[0m");
            }
        }
    } // End of deleteStudent()


    // The option 9
    protected void searchStudentWithName() {

        System.out.println("\033[36m\n--------------------------\033[0m");
        System.out.println("\033[36m Search Student with Name \033[0m");
        System.out.println("\033[36m--------------------------\033[0m");

        if (studentStore.isEmpty()) {
            System.out.println("\033[36m<Before you choose other option, you should add a student at first (Option 1).>\033[0m");
        } else {

            System.out.print("\033[36m[Enter a name to search] \033[0m");
            String name = input.nextLine().trim();

            boolean flag = false;
            for (int i = 0; i < studentStore.size(); i++) {
                if (studentStore.get(i).getName().equals(name)) {
                    System.out.println(studentStore.get(i));
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("\033[36m<Name does not exist!>\033[0m");
            }

        }
    } // End of SearchStudentWithName()

} // End of SuperDriver Class

