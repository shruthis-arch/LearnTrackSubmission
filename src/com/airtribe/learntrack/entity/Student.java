package LearnTrack.src.com.airtribe.learntrack.entity;

import LearnTrack.src.com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person{

    private String batch;
    private boolean active;

        
    // Parametrized constructor
    public Student(String firstName, String lastName, String email, String batch, boolean active) {
        super(IdGenerator.getNextStudentId(), firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    // Parametrized constructor overloaded (without email)
    public Student(String firstName, String lastName, String batch, boolean active) {
        super(IdGenerator.getNextStudentId(),firstName, lastName, batch);
        this.batch = batch;
        this.active = active;
    }

    // Getters and Setters 
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBatch() {
        return batch;
    }
    public void setBatch(String batch) {
        this.batch = batch;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Override 
    public void getDisplayName(){
        System.out.println("Student name is : " + getFirstName() + " " + getLastName());
    }

    public void diplayStudentData(){
        System.out.println(this.getId() + " | " + this.getFirstName() + " | "
            + this.getLastName() + " | " + this.getEmail() + " | "  + 
            this.getBatch() + " | " + this.isActive());
            System.out.println();
    }
}
