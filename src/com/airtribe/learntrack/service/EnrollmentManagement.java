package LearnTrack.src.com.airtribe.learntrack.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import LearnTrack.src.com.airtribe.learntrack.entity.Course;
import LearnTrack.src.com.airtribe.learntrack.entity.Enrollment;
import LearnTrack.src.com.airtribe.learntrack.entity.Student;
import LearnTrack.src.com.airtribe.learntrack.enums.EnrollmentStatus;
import LearnTrack.src.com.airtribe.learntrack.exceptions.EntityNotFoundExceptions;
import LearnTrack.src.com.airtribe.learntrack.repository.CourseRepository;
import LearnTrack.src.com.airtribe.learntrack.repository.EnrollmentRepository;
import LearnTrack.src.com.airtribe.learntrack.repository.StudentRepository;

public class EnrollmentManagement {

    /*
     * To enroll a student into a course
     */
    public void enrollStudent(String studentId, String courseId,
            StudentRepository studentRepository, CourseRepository courseRepository,
            EnrollmentRepository enrollmentRepository) throws EntityNotFoundExceptions {

        StudentManagement studentService = new StudentManagement();
        CourseManagement courseService = new CourseManagement();
        Student student = studentService.searchStudent(studentId, studentRepository);
        Course course = courseService.searchCourse(courseId, courseRepository);

        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment(studentId, courseId,
                    LocalDate.now());
            enrollmentRepository.getEnrollmentList().add(enrollment);
        }
    }

    /*
     * To view enrollements for a student
     */
    public void viewEnrollmentsForStudent(String studentId, StudentRepository studentRepository,
            EnrollmentRepository enrollmentRepository) throws EntityNotFoundExceptions {
        StudentManagement studentService = new StudentManagement();
        List<Enrollment> studentEnrollment = new ArrayList<>();
        // Check if it is a valid StudentId
        Student student = studentService.searchStudent(studentId, studentRepository);
        if (student != null) {
            for (Enrollment enrollment : enrollmentRepository.getEnrollmentList()) {
                if (enrollment.getStudentId().equals(studentId)) {
                    studentEnrollment.add(enrollment);
                }
            }
        }

        System.out.println("List of enrollnments for Student " + studentId);
        System.out.println("    Enrollment Id  |    Student Id      |   Course Id   |   Enrollment Date |   Status  ");
        for (Enrollment enrollment : studentEnrollment) {
            System.out.println(
                    enrollment.getEid() + " | " + enrollment.getStudentId() + "  |   " + enrollment.getCourseId()
                            + "    |   " + enrollment.getEnrollmentDate() + "    |   " + enrollment.getStatus());
        }
    }

    /*
     * To mark enrollement as Completed
     */
    public void completeEnrollment(String enrollmentId, EnrollmentRepository enrollmentRepository)
            throws EntityNotFoundExceptions {
        for (Enrollment enrollment : enrollmentRepository.getEnrollmentList()) {
            if (enrollment.getEid().equals(enrollmentId)) {
                enrollment.setStatus(EnrollmentStatus.COMPLETED);
            }
        }
    }

    /*
     * To mark enrollement as Cancelled
     */
    public void cancelEnrollment(String enrollmentId, EnrollmentRepository enrollmentRepository)
            throws EntityNotFoundExceptions {
        for (Enrollment enrollment : enrollmentRepository.getEnrollmentList()) {
            if (enrollment.getEid().equals(enrollmentId)) {
                enrollment.setStatus(EnrollmentStatus.CANCELLED);
            }
        }
    }
}
