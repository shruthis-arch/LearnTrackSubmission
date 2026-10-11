package LearnTrack.src.com.airtribe.learntrack.entity;

import LearnTrack.src.com.airtribe.learntrack.util.IdGenerator;

public class Trainer extends Person{
    
    String designation;
    double salary;

    public Trainer(String firstName, String lastName, String email, String designation, double salary) {
        super(IdGenerator.getNextTrainerId(), firstName, lastName, email);
        this.designation = designation;
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override 
    public void getDisplayName(){
        System.out.println("Trainer name is : " + getFirstName() + " " + getLastName());
    }

}
