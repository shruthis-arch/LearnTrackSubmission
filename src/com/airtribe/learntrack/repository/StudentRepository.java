package LearnTrack.src.com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import LearnTrack.src.com.airtribe.learntrack.entity.Student;


public class StudentRepository {
    private List<Student> StudentList;

    public StudentRepository() {
        this.StudentList = new ArrayList<>();
    }

    // Getter to return list of students
    public List<Student> getStudentList() {
        return StudentList;
    }
    
}
