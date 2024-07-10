package fact;
import service.Constants;
import service.AcademicAbility;
import java.text.SimpleDateFormat;
import fact.Person;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student extends Person {

    private String studentCode;
    private String university;
    private int startYear;
    private double  gpa;
    private AcademicAbility academicAbility;


    public Student(int id, String name, LocalDate birthDate, String address, double height, double weight, String studentCode, String university, int startYear, double gpa){
        super(id, name, birthDate, address, height, weight);
        setStudentCode(studentCode);
        setUniversity(university);
        setStartYear(startYear);
        setGPA(gpa);
    }

    public String getStudentCode(){
        return studentCode;
    }

    public void setStudentCode(String studentCode){
        if(studentCode != null && studentCode.length() <= Constants.STUDENTCODE_SIZE){
            this.studentCode = studentCode;
        }
    }

    public String getuniversity(){
        return university;
    }

    public void setUniversity(String university){
        if(university != null || university.length() <= Constants.MAX_UNIVERSITY_SIZE){
            this.university = university;
        }
        else{
            System.out.println("Your university is NOT Invalid");
        }
    }

    public int getStartYear(){
        return startYear;
    }

    public void setStartYear(int startYear){
        if(startYear >= Constants.START_YEAR){
            this.startYear = startYear;
        }
        else{
            System.out.println("Your start year is NOT Invalid");
        }
    }

    public double getGPA(){
        return gpa;
    }

    public void setGPA(double gpa){
        if(gpa >= Constants.MIN_GPA && gpa <= Constants.MAX_GPA){
            this.gpa = gpa;
            updateAcademicAbility();
        }
        else{
            System.out.println("Your GPA is NOT Invalid");
        }
    }

    public AcademicAbility getAcademicAbility() {
        return academicAbility;
    }

    private void updateAcademicAbility() {
        if (gpa < 3) {
            this.academicAbility = AcademicAbility.KEM;
        } else if (gpa < 5) {
            this.academicAbility = AcademicAbility.YEU;
        } else if (gpa < 6.5) {
            this.academicAbility = AcademicAbility.TRUNG_BINH;
        } else if (gpa < 7.5) {
            this.academicAbility = AcademicAbility.KHA;
        } else if (gpa < 9) {
            this.academicAbility = AcademicAbility.GIOI;
        } else {
            this.academicAbility = AcademicAbility.XUAT_SAC;
        }
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = getBirthDate().format(formatter);

        return "ID : " + getID() + "\n" +
                "Name : " + getName() + "\n" +
                "Birthday : " + date + "\n" +
                "Address : " + getAddress() + "\n" +
                "Height : " + getHeight() + "\n" +
                "Weight : " + getWeight() + "\n" +
                "Student Code : " + studentCode + "\n" +
                "University : " + university + "\n" +
                "Start Year : " + startYear + "\n" +
                "GPA: " + gpa + "\n" +
                "Academic Ability: " + academicAbility.getDescription();
    }
}
