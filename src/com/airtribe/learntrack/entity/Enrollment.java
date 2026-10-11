package LearnTrack.src.com.airtribe.learntrack.entity;
import java.time.LocalDate;
import LearnTrack.src.com.airtribe.learntrack.util.IdGenerator;
import LearnTrack.src.com.airtribe.learntrack.enums.EnrollmentStatus;

public class Enrollment {
    private String eid;
    private String studentId;
    private String courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    // Parametrized constructor
    public Enrollment(String studentId, String courseId, LocalDate enrollmentDate) {
        this.eid = IdGenerator.getNextEnrollmentId();
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = EnrollmentStatus.ACTIVE;
    }

    // Getters and Setters
    public String getEid() {
        return eid;
    }
    
    public void setEid(String eid) {
        this.eid = eid;
    }
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    public EnrollmentStatus getStatus() {
        return status;
    }
    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }    
}
