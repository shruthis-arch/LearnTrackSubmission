package LearnTrack.src.com.airtribe.learntrack.entity;

import LearnTrack.src.com.airtribe.learntrack.enums.CourseStatus;
import LearnTrack.src.com.airtribe.learntrack.util.IdGenerator;

public class Course {
    private String cid;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;
    
    // Parametrized constructor
    public Course(String courseName, String description, int durationInWeeks) {
        this.cid = IdGenerator.getNextCourseId();
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = CourseStatus.ACTIVE;
    }

    // Getters and Setters
    public String getId() {
        return cid;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getDurationInWeeks() {
        return durationInWeeks;
    }
    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }
    public CourseStatus getStatus() {
        return status;
    }
    public void setActive(CourseStatus status) {
        this.status = status;
    }

    public void diplayCourseData(){
        System.out.println(this.getId() + " | " + this.getCourseName() + " | "
            + this.getDescription() + " | " + this.getDurationInWeeks() + " | "  + 
            this.getStatus());
            System.out.println();
    }
}
