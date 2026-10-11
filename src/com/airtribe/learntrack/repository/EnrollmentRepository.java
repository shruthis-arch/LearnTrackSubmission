package LearnTrack.src.com.airtribe.learntrack.repository;

import java.util.ArrayList;
import java.util.List;

import LearnTrack.src.com.airtribe.learntrack.entity.Enrollment;

public class EnrollmentRepository {
    private List<Enrollment> EnrollmentList;

    public EnrollmentRepository() {
        this.EnrollmentList = new ArrayList<>();
    }

    public List<Enrollment> getEnrollmentList() {
        return EnrollmentList;
    }

}
