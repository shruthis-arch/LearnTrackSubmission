package LearnTrack.src.com.airtribe.learntrack.service;

import LearnTrack.src.com.airtribe.learntrack.entity.Course;
import LearnTrack.src.com.airtribe.learntrack.enums.CourseStatus;
import LearnTrack.src.com.airtribe.learntrack.exceptions.EntityNotFoundExceptions;
import LearnTrack.src.com.airtribe.learntrack.exceptions.InvalidInputException;
import LearnTrack.src.com.airtribe.learntrack.repository.CourseRepository;
import LearnTrack.src.com.airtribe.learntrack.util.InputValidator;

public class CourseManagement {

    /*
    * To add a course to the course repository
    */
    public void addCourse(Course course, CourseRepository courseRepository) throws InvalidInputException{
        InputValidator.isValidName(course.getCourseName());
        courseRepository.getCourseList().add(course);
        System.out.println("Course added successfully");
    }

    /*
    * To view list of courses 
    */
    public void viewCourseList(CourseRepository courseRepository){
        System.out.println("  Course id  |  Course Name  |             Description            | Duration (in weeks) |  Active  |");
        for(Course course : courseRepository.getCourseList()){
            course.diplayCourseData();
        }
    }

    /*
    *   To search a course
    */
   public Course searchCourse(String id, CourseRepository courseRepository) throws EntityNotFoundExceptions {
        for(Course course : courseRepository.getCourseList()){
            if(id.equals(course.getId())){
                return course;
            }
        }
         throw new EntityNotFoundExceptions("Course Id not Found");
    }

    /*
    *  To deactivate a course
    */
    public void deactivateCourse(String courseId, CourseRepository courseRepository) throws EntityNotFoundExceptions{
        Course course = searchCourse(courseId, courseRepository);
        course.setActive(CourseStatus.INACTIVE);
        System.out.println("Course deactivated successfully");
    }

    /*
    *  To activate a course
    */
    public void activateCourse(String courseId, CourseRepository courseRepository) throws EntityNotFoundExceptions{
        Course course = searchCourse(courseId, courseRepository);
        course.setActive(CourseStatus.ACTIVE);
        System.out.println("Course activated successfully");
    }
}
