package service;
import fact.Student;

import java.util.*;
import service.AcademicAbility;
import static service.ArrayStudent.studentCount;
import static service.ArrayStudent.students;


public class ManagerStudent {
    public static ArrayList<Student> listStudent = new ArrayList<>();

    public static void displayAcademicAbility() {
        int totalStudents = listStudent.size();
        if (totalStudents == 0) {
            System.out.println("No Students exist in the list");
            return;
        }
        int[] counts = new int[AcademicAbility.values().length];

        for (Student student : listStudent) {
            counts[student.getAcademicAbility().ordinal()]++;
        }
        Map<AcademicAbility, Double> academicMap = new HashMap<AcademicAbility, Double>();
        for (AcademicAbility ability : AcademicAbility.values()) {
            double percentage = (counts[ability.ordinal()] / (double) totalStudents) * 100;
            academicMap.put(ability, percentage);
        }
        List<Map.Entry<AcademicAbility, Double>> list = new ArrayList<>(academicMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<AcademicAbility, Double>>() {
            @Override
            public int compare(Map.Entry<AcademicAbility, Double> o1, Map.Entry<AcademicAbility, Double> o2) {
                return Double.compare(o2.getValue(), o1.getValue());
            }
        });
        Map<AcademicAbility, Double> finalAcademic = new LinkedHashMap<>();
        for(Map.Entry<AcademicAbility, Double> entry : list){
            finalAcademic.put(entry.getKey(), entry.getValue());
        }
        System.out.println("Academic Ability Percentages:");
        for(Map.Entry<AcademicAbility, Double> x : finalAcademic.entrySet()){
            System.out.printf("%s: %.2f%%\n", x.getKey().getDescription(), x.getValue());
        }
    }
    public static void percentagePoints(){
        int sumStudent = listStudent.size();
        if (sumStudent == 0) {
            System.out.println("No Students exist in the list");
            return;
        }
        TreeMap<Double, Integer> gpaMap = new TreeMap<>();
        for(Student student : listStudent){
            double gpa = student.getGPA();
            gpaMap.put(gpa, gpaMap.getOrDefault(gpa, 0) + 1);
        }
        System.out.println("Percentage Points: ");
        for(Map.Entry<Double,Integer> entry : gpaMap.entrySet()){
            double percentage = (entry.getValue()/(double)sumStudent) * 100;
            System.out.printf("%.1f: %.2f%%\n", entry.getKey(), percentage);
        }
    }
    public static void findStudentAcademic(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("1.Xuất Sắc");
            System.out.println("2.Giỏi");
            System.out.println("3.Khá");
            System.out.println("4.Trung Bình");
            System.out.println("5.Yếu");
            System.out.println("6.Kém");
            System.out.println("7.Exit");
            System.out.print("Your choice : ");
            int input = scanner.nextInt();
            ArrayList<Student> findStudent = new ArrayList<>();
            for(Student student : listStudent){
                switch (input){
                    case 1:
                        if(student.getGPA() >= (double)9.0){
                            findStudent.add(student);
                        }
                        break;
                    case 2:
                        if(student.getGPA() >= (double)7.5 && student.getGPA() < (double)9.0){
                            findStudent.add(student);
                        }
                        break;
                    case 3:
                        if(student.getGPA() >= (double)6.5 && student.getGPA() < (double)7.5){
                            findStudent.add(student);
                        }
                        break;
                    case 4:
                        if(student.getGPA() >= (double)5.0 && student.getGPA() < (double)6.5){
                            findStudent.add(student);
                        }
                        break;
                    case 5:
                        if(student.getGPA() >= (double)3.0 && student.getGPA() < (double)5.0){
                            findStudent.add(student);
                        }
                        break;
                    case 6:
                        if(student.getGPA() < (double)3.0){
                            findStudent.add(student);
                        }
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Invalid academic performance");
                        break;
                }
            }
            if(findStudent.size() >= 1){
                System.out.println("The students have academic ability ");
                for(Student student : findStudent){
                    System.out.println(student);
                }
                return;
            }
            else{
                System.out.println("There are NO students who meet the requirements");
            }
        }
    }
}
