package LearnTrack.src.com.airtribe.learntrack.service;

import LearnTrack.src.com.airtribe.learntrack.entity.Student;
import LearnTrack.src.com.airtribe.learntrack.exceptions.EntityNotFoundExceptions;
import LearnTrack.src.com.airtribe.learntrack.exceptions.InvalidInputException;
import LearnTrack.src.com.airtribe.learntrack.repository.StudentRepository;
import LearnTrack.src.com.airtribe.learntrack.util.InputValidator;

public class StudentManagement {

    /*
    * To add a student to the student repository
    */
    public void addStudent(Student student, StudentRepository studentRepository) throws InvalidInputException{
        InputValidator.isValidName(student.getFirstName());
        InputValidator.isValidName(student.getLastName());
        InputValidator.isValidEmail(student.getEmail());
        studentRepository.getStudentList().add(student);
        System.out.println("Student added successfully");
    }

    /*
    * To view list of students 
    */
    public void viewStudentList(StudentRepository studentRepository){
        System.out.println("  Student id  |  First Name  |  Last Name  |         Email         |  Batch  |  Active  |");
        for(Student student : studentRepository.getStudentList()){
            student.diplayStudentData();
        }
    }

 
   /*
    * To update a student 
    */
   public void updateStudent(StudentRepository studentRepository, Student updatedStudent) throws EntityNotFoundExceptions{
        Student student = this.searchStudent(updatedStudent.getId(), studentRepository);
        
        if (updatedStudent.getFirstName() == null) {student.setFirstName(updatedStudent.getFirstName());}
        if (updatedStudent.getLastName() == null) {student.setLastName(updatedStudent.getLastName());}
        if(updatedStudent.getEmail() == null) {student.setEmail(updatedStudent.getEmail());}
        if(updatedStudent.getBatch() == null) {student.setBatch(updatedStudent.getBatch());}
        if(updatedStudent.isActive() != updatedStudent.isActive()) {student.setActive(updatedStudent.isActive());}
   }

   //Overloaded method to update only Student name
   public void updateStudent(StudentRepository studentRepository, String studentId, String firstName, String lastName) throws EntityNotFoundExceptions{
        Student student = this.searchStudent(studentId, studentRepository);
        student.setFirstName(firstName);
        student.setLastName(lastName);
   }

   //Overloaded method to update only Student emailID
   public void updateStudent(StudentRepository studentRepository, String studentId, String emailId) throws EntityNotFoundExceptions{
        Student student = this.searchStudent(studentId, studentRepository);
        student.setEmail(emailId);
   }

    /*
    * To search a student by ID
    */
    public Student searchStudent(String id, StudentRepository studentRepository) throws EntityNotFoundExceptions {
        for(Student student : studentRepository.getStudentList()){
            if(id.equals(student.getId())){
                return student;
            }
        }
         throw new EntityNotFoundExceptions("Student Id not Found");
    }

    /*
    * To deactivate a student
    */
    public void deactivateStudent(String studentId, StudentRepository studentRepository) throws EntityNotFoundExceptions{
        Student student = searchStudent(studentId, studentRepository);
        student.setActive(false);
        System.out.println("Student deactivated successfully");
    }

}
