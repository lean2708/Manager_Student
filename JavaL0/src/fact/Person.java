package fact;

import service.Constants;
import java.time.LocalDate;



public class Person {

    private int id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private double height;
    private double weight;

    public Person(int id, String name, LocalDate birthDate, String address, double height, double weight){
        setID(id);
        setName(name);
        setBirthDay(birthDate);
        setAddress(address);
        setHeight(height);
        setWeight(weight);
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        if(id >= Constants.MIN_ID){
            this.id = id;
        }
        else{
            System.out.println("Your ID is NOT Invalid");
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name != null && name.length() < Constants.MAX_NAME_SIZE){
            this.name = name;
        }
        else{
            System.out.println("Your name is NOT Invalid");
        }
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDay(LocalDate birthDate){
        if(birthDate != null){
            this.birthDate = birthDate;
        }
        else{
            System.out.println("Your Birthday is NOT Invalid");
        }
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        if(address.length() < Constants.MAX_ADDRESS){
            this.address = address;
        }
        else{
            System.out.println("Your address is NOT Invalid");
        }
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        if(height >= Constants.MIN_HEIGHT && height <= Constants.MAX_HEIGHT){
            this.height = height;
        }
        else{
            System.out.println("Your height is NOT Invalid");
        }
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        if(weight >= Constants.MIN_WEIGHT && weight <= Constants.MAX_WEIGHT){
            this.weight = weight;
        }
        else{
            System.out.println("Your weight is NOT Invalid");
        }
    }

    public String toString(){
        return "ID : " + id + "\n" +
                "Name : " + name + "\n" +
                "BirthDay : " + birthDate + "\n" +
                "Address : " + address + "\n" +
                "Height : " + height + "\n" +
                "Weight : " + weight;
    }

}
