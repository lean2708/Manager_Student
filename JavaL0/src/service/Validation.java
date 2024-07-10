package fact.service;
import service.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {
    public static ArrayList<String> ListCode = new ArrayList<>();
    public static int idCount = 1;
    public static int ExamineID(){
            int id = idCount;
            idCount += 1;
            System.out.println("ID: " + id);
            return id;
    }
    public static String ExamineName(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            boolean number = false;
            for(int i = 0; i < name.length(); i++){
                if(Character.isDigit(name.charAt(i))){
                    number = true;
                    break;
                }
            }
            if (name.length() == 0 || name.length() > service.Constants.MAX_NAME_SIZE || number == true || Constants.CheckSpace(name)) {
                System.out.println("Your Name is NOT Valid");
            }
            else {
                System.out.println("Your Name is Valid");
                return name;
            }
        }
    }
    public static LocalDate ExamineBirthday(){
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Birthday (dd/mm/yyyy): ");
                String input = scanner.nextLine();
                String[] parts = input.split("/");

                if (parts.length != 3) {
                    throw new DateTimeParseException("Invalid input format", input, 0);
                }

                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                if (Constants.CheckBirthday(day, month, year)) {
                    LocalDate birthday = LocalDate.of(year, month, day);
                    System.out.println("Your Birthday is Valid");
                    return birthday;
                } else {
                    System.out.println("Your Birthday is NOT Valid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Your Birthday is NOT Valid");
            } catch (DateTimeParseException e) {
                System.out.println("Your Birthday is NOT Valid");
            }
        }
    }
    public static String ExamineAddress(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Address: ");
            String address = scanner.nextLine();
            if(address.length() == 0 || address.length() > service.Constants.MAX_ADDRESS || Constants.CheckSpace(address)){
            System.out.println("Your Address is NOT Valid");
            }
            else{
            System.out.println("Your Address is Valid");
            return address;
            }
        }
    }
    public static double ExamineHeight(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Height (50-300cm): ");
            String inputHeight = scanner.nextLine();
            try{
                Double height = Double.parseDouble(inputHeight);
                if(height < Constants.MIN_HEIGHT || height > Constants.MAX_HEIGHT){
                    System.out.println("Your Height is NOT Valid");
                }
                else{
                    System.out.println("Your Height is Valid");
                    return height;
                }
            }catch (NumberFormatException e) {
                System.out.println("Your Height is NOT Valid");
            }
        }
    }
    public static double ExamineWeight(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Weight (5-1000kg): ");
            String inputWeight = scanner.nextLine();
            try{
                double weight = Double.parseDouble(inputWeight);
                if(weight < Constants.MIN_WEIGHT || weight > Constants.MAX_WEIGHT){
                    System.out.println("Your Weight is NOT Valid");
                }
                else{
                    System.out.println("Your Weight is Valid");
                    return weight;
                }
            }catch (NumberFormatException e) {
                System.out.println("Your Weight is NOT Valid");
            }
        }
    }
    public static String ExamineStudentCode(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Student Code (10 characters): ");
            String studentCode = scanner.nextLine();
            if((studentCode.length() != service.Constants.STUDENTCODE_SIZE) || ListCode.contains(studentCode) || Constants.CheckSpace(studentCode)){
                System.out.println("Your Student Code is NOT Valid");
            }
            else{
                System.out.println("Your Student Code is Valid");
                ListCode.add(studentCode);
                return studentCode;
            }
        }

    }
    public static String ExamineUniversity(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("University: ");
            String university = scanner.nextLine();
            if(university.length() == 0 || university.length() > service.Constants.MAX_UNIVERSITY_SIZE || Constants.CheckSpace(university)){
                System.out.println("Your University is NOT Valid");
            }
            else{
                System.out.println("Your University is Valid");
                return university;
            }
        }
    }
    public static int ExamineStartYear(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Start Year: ");
            String inputStartYear = scanner.nextLine();
            try{
                int startYear = Integer.parseInt(inputStartYear);
                if(startYear < Constants.MIN_YEAR || startYear > Constants.MAX_YEAR){
                    System.out.println("Your Start Year is NOT Valid");
                }
                else{
                    System.out.println("Your Start Year is Valid");
                    return startYear;
                }
            }catch (NumberFormatException e) {
                System.out.println("Your Start Year is NOT Valid");
            }
        }
    }
    public static double ExamineGPA(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("GPA (0-10): ");
            if(scanner.hasNextDouble()) {
                double gpa = scanner.nextDouble();
                if (gpa < service.Constants.MIN_GPA || gpa > service.Constants.MAX_GPA) {
                    System.out.println("Your GPA is NOT Valid");
                } else {
                    System.out.println("Your GPA is Valid");
                    return gpa;
                }
            }
            else{
                System.out.println("Your GPA is NOT Valid");
                scanner.next();
            }
        }
    }
}
