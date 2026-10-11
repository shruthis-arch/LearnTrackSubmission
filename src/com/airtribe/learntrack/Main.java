package LearnTrack.src.com.airtribe.learntrack;


import java.util.Scanner;

import LearnTrack.src.com.airtribe.learntrack.entity.Student;
import LearnTrack.src.com.airtribe.learntrack.entity.Course;
import LearnTrack.src.com.airtribe.learntrack.repository.StudentRepository;
import LearnTrack.src.com.airtribe.learntrack.repository.CourseRepository;
import LearnTrack.src.com.airtribe.learntrack.repository.EnrollmentRepository;
import LearnTrack.src.com.airtribe.learntrack.service.StudentManagement;
import LearnTrack.src.com.airtribe.learntrack.service.CourseManagement;
import LearnTrack.src.com.airtribe.learntrack.service.EnrollmentManagement;
import LearnTrack.src.com.airtribe.learntrack.exceptions.EntityNotFoundExceptions;
import LearnTrack.src.com.airtribe.learntrack.exceptions.InvalidInputException;

public class Main {

    public static void main(String[] args) {

        StudentManagement studentService = new StudentManagement();
        CourseManagement courseService = new CourseManagement();
        EnrollmentManagement enrollementService = new EnrollmentManagement();

        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("==== Student and Course Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Find Student");
            System.out.println("4. Update Student");
            System.out.println("5. Deactivate Student");
            System.out.println("6. Add Course");
            System.out.println("7. List Courses");
            System.out.println("8. Search Course");
            System.out.println("9. Activate Course");
            System.out.println("10. Deactivate Course");
            System.out.println("11. Enroll Student");
            System.out.println("12. View enrollments for Student");
            System.out.println("13. Complete Enrollment");
            System.out.println("14. Cancelled Enrollment");

            System.out.println("Enter Choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Enter First Name : ");
                        String firstName = scanner.nextLine();
                        System.out.println("Enter Last Name : ");
                        String lastName = scanner.nextLine();
                        System.out.println("Enter Email Id : ");
                        String email = scanner.nextLine();
                        System.out.println("Enter Batch : ");
                        String batch = scanner.nextLine();
                        System.out.println("Enter status active (true/false) :");
                        boolean active = scanner.nextBoolean();

                        Student s = new Student(firstName, lastName, email, batch, active);
                        studentService.addStudent(s, studentRepository);
                        break;

                    case 2:
                        studentService.viewStudentList(studentRepository);
                        break;

                    case 3:
                        String studentId = scanner.nextLine();
                        studentService.searchStudent(studentId, studentRepository);
                        break;

                    case 4:
                        System.out.println("Enter Student Id : ");
                        String studentId2 = scanner.nextLine();
                        System.out.println("Enter Email Id : ");
                        String newEmail = scanner.nextLine();
                        studentService.updateStudent(studentRepository, studentId2, newEmail);
                        break;

                    case 5:
                        System.out.println("Enter Student Id : ");
                        String studentId3 = scanner.nextLine();
                        studentService.deactivateStudent(studentId3, studentRepository);
                        break;

                    case 6:
                        System.out.println("Enter course name : ");
                        String courseName = scanner.nextLine();
                        System.out.println("Enter description : ");
                        String description = scanner.nextLine();
                        System.out.println("Enter durationInWeeks : ");
                        int durationInWeeks = scanner.nextInt();
                        Course course = new Course(courseName, description, durationInWeeks);
                        courseService.addCourse(course, courseRepository);
                        break;

                    case 7:
                        courseService.viewCourseList(courseRepository);
                        break;

                    case 8:
                        System.out.println("Enter course Id : ");
                        String courseId = scanner.nextLine();
                        courseService.searchCourse(courseId, courseRepository);
                        break;

                    case 9:
                        System.out.println("Enter Course Id : ");
                        String courseId2 = scanner.nextLine();
                        courseService.activateCourse(courseId2, courseRepository);
                        break;

                    case 10:
                        System.out.println("Enter Course Id : ");
                        String courseId3 = scanner.nextLine();
                        courseService.deactivateCourse(courseId3, courseRepository);
                        break;

                    case 11:
                        System.out.println("Enter Student Id");
                        String studentId4 = scanner.nextLine();
                        System.out.println("Enter Course Id");
                        String courseId4 = scanner.nextLine();
                        enrollementService.enrollStudent(studentId4, courseId4, studentRepository, courseRepository,
                                enrollmentRepository);
                        break;

                    case 12:
                        System.out.println("Enter Student Id");
                        String studentId5 = scanner.nextLine();
                        enrollementService.viewEnrollmentsForStudent(studentId5, studentRepository,
                                enrollmentRepository);
                        break;

                    case 13:
                        System.out.println("Enter Enrollment Id");
                        String enrollmentId = scanner.nextLine();
                        enrollementService.completeEnrollment(enrollmentId, enrollmentRepository);
                        break;

                    case 14:
                        System.out.println("Enter Enrollment Id");
                        String enrollmentId2 = scanner.nextLine();
                        enrollementService.cancelEnrollment(enrollmentId2, enrollmentRepository);
                        break;
                    case 0:
                        System.out.println("Enter valid choice");
                        break;
                }

            } catch (InvalidInputException e) {

                System.out.println(
                        "Input Validation Error : "
                                + e.getMessage());

            } catch (EntityNotFoundExceptions e) {

                System.out.println(
                        "Entity Error : "
                                + e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid menu option");

            } catch (Exception e) {

                System.out.println(
                        "Unexpected Error : "
                                + e.getMessage());
            }
        }

        scanner.close();
    }

}
