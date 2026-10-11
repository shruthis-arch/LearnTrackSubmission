package LearnTrack.src.com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import LearnTrack.src.com.airtribe.learntrack.entity.Course;

public class CourseRepository {
   
    private List<Course> CourseList;

    public CourseRepository() {
        this.CourseList = new ArrayList<>();
    }

    // Getters
    public List<Course> getCourseList() {
        return CourseList;
    }
}
