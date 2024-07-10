

import fact.service.Validation;
import service.ArrayStudent;
import fact.Student;
import service.FileStudent;
import service.ManagerStudent;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("MENU:");
            System.out.println("1. Create Student");
            System.out.println("2. Search for Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Percentage Of Academic Performance");
            System.out.println("6. Percentage Points");
            System.out.println("7. Search for academic performance");
            System.out.println("8. Student List");
            System.out.println("9. Exit");
            System.out.print("Your Choice : ");
            try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        int id = Validation.ExamineID();

                        String name = Validation.ExamineName();

                        LocalDate birthDate = Validation.ExamineBirthday();

                        String address = Validation.ExamineAddress();

                        double height = Validation.ExamineHeight();

                        double weight = Validation.ExamineWeight();

                        String studentCode = Validation.ExamineStudentCode();

                        String university = Validation.ExamineUniversity();

                        int startYear = Validation.ExamineStartYear();

                        double gpa = Validation.ExamineGPA();
                        ArrayStudent.createStudent(id, name, birthDate, address, height, weight, studentCode, university, startYear, gpa);
                        break;
                    case 2:
                        while(true){
                            System.out.print("Student ID to Find: ");
                            try{
                                int idFind = scanner.nextInt();
                                scanner.nextLine();
                                Student student = ArrayStudent.findStudent(idFind);
                                if (student != null) {
                                    System.out.println(student);
                                }
                                break;
                            }catch (InputMismatchException e) {
                                System.out.println("Your ID is NOT Valid");
                                scanner.next();
                            }
                        }
                        break;
                    case 3:
                        ArrayStudent.updateStudent();
                        break;
                    case 4:
                        while(true){
                            System.out.print("Student ID to delete: ");
                            try{
                                int idDelete = scanner.nextInt();
                                scanner.nextLine();
                                ArrayStudent.deleteStudent(idDelete);
                                break;
                            }catch (InputMismatchException e) {
                                System.out.println("Your ID is NOT Valid");
                                scanner.next();
                            }
                        }
                        break;
                    case 5:
                        ManagerStudent.displayAcademicAbility();
                        break;
                    case 6:
                        service.ManagerStudent.percentagePoints();
                        break;
                    case 7:
                        service.ManagerStudent.findStudentAcademic();
                        break;
                    case 8:
                        ArrayStudent.StudentList();
                        break;
                    case 9:
                        System.out.println("Exit");
                        scanner.close();
                        ArrayStudent.SaveFile();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }catch (InputMismatchException e) {
                System.out.println("You choose wrong or choose again");
                scanner.next();
            }
        }
    }
}
