package service;

import fact.Student;
import fact.service.Validation;

import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayStudent {

    private static final int MAX_STUDENTS = 200;
    public static Student[] students = new Student[MAX_STUDENTS];
    public static int studentCount = 0;

    public static void createStudent(int id, String name, LocalDate birthDate, String address, double height, double weight, String studentCode, String university, int startYear, double gpa){
        if(studentCount < MAX_STUDENTS){
            Student newStudent = new Student(id, name, birthDate, address, height, weight, studentCode, university, startYear, gpa);
            students[studentCount++] = newStudent;
            ManagerStudent.listStudent.add(newStudent);
            System.out.println("Student has been successfully added : " + "\n" + newStudent);
        }
        else {
            System.out.println("Cannot add Students");
        }
    }

    public static Student findStudent(int id){
        if(studentCount == 0){
            System.out.println("No students exist in the list");
            return null;
        }
        for(int i = 0; i < studentCount; i++){
            if(students[i].getID() == id){
                return students[i];
            }
        }
        System.out.println("No student found with ID: " + id);
        return null;
    }
    public static void updateStudent() throws ParseException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Student ID to Update: ");
            int idUpdate = scanner.nextInt();
            Student student = ArrayStudent.findStudent(idUpdate);
            if(student != null) {
                System.out.println("1.Name");
                System.out.println("2.Birthday (dd/MM/yyyy)");
                System.out.println("3.Address");
                System.out.println("4.Height(cm)");
                System.out.println("5.Weight(kg)");
                System.out.println("6.Student Code");
                System.out.println("7.University");
                System.out.println("8.Start Year");
                System.out.println("9.GPA");
                System.out.println("10.Exit");
                System.out.print("Your choice : ");
                try{
                    int input = scanner.nextInt();
                    switch ((input)) {
                        case 1:
                            String name = Validation.ExamineName();
                            student.setName(name);
                            int indexName = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexName).setName(name);
                            break;
                        case 2:
                            LocalDate birthDate = Validation.ExamineBirthday();
                            student.setBirthDay(birthDate);
                            int indexBirth = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexBirth).setBirthDay(birthDate);
                            break;
                        case 3:
                            String address = Validation.ExamineAddress();
                            student.setAddress(address);
                            int indexAddress = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexAddress).setAddress(address);
                            break;
                        case 4:
                            double height = Validation.ExamineHeight();
                            student.setHeight(height);
                            int indexHeight = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexHeight).setHeight(height);
                            break;
                        case 5:
                            double weight = Validation.ExamineWeight();
                            student.setWeight(weight);
                            int indexWeight = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexWeight).setWeight(weight);
                            scanner.nextLine();
                            break;
                        case 6:
                            String studentCode = Validation.ExamineStudentCode();
                            student.setStudentCode(studentCode);
                            int indexCode = Validation.ListCode.indexOf(student.getStudentCode());
                            Validation.ListCode.set(indexCode, studentCode);
                            int indexStudentCode = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexStudentCode).setStudentCode(studentCode);
                            break;
                        case 7:
                            String university = Validation.ExamineUniversity();
                            student.setUniversity(university);
                            int indexUniversity = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexUniversity).setUniversity(university);
                            break;
                        case 8:
                            int startYear = Validation.ExamineStartYear();
                            student.setStartYear(startYear);
                            int indexStartYear = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexStartYear).setStartYear(startYear);
                            break;
                        case 9:
                            double gpa = Validation.ExamineGPA();
                            student.setGPA(gpa);
                            int indexGPA = ManagerStudent.listStudent.indexOf(student);
                            ManagerStudent.listStudent.get(indexGPA).setGPA(gpa);
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                    System.out.println("Students were successfully Updated " + student);
                    return;
                }
                catch (InputMismatchException e) {
                    System.out.println("You choose wrong or choose again");
                    scanner.next();
                }
            }
        }
    }

    public static void deleteStudent(int id){
        for(int i = 0; i < studentCount; i++){
            if(students[i].getID() == id){
                Validation.ListCode.remove(students[i].getStudentCode());
                ManagerStudent.listStudent.remove(students[i]);
                for(int j = i; j < studentCount; j++){
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;
                System.out.println("Student delete successfully");
                return;
            }
        }
        System.out.println("No student found with ID: " + id);
    }

    public static void StudentList(){
        if(studentCount == 0){
            System.out.println("No students exist in the list");
        }
        else{
            System.out.println("Student list includes " + studentCount + " students");
            for(int i = 0; i < studentCount; i++){
                System.out.println(students[i]);
            }
        }
    }
    public static void SaveFile() throws IOException {
        ArrayList<Student> studentList = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            studentList.add(students[i]);
        }
        FileStudent.SaveFile(studentList);
    }
}
