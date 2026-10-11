package LearnTrack.src.com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter = 0;
    private static int courseIdCounter = 0;
    private static int trainerIdCounter = 0;
    private static int enrollmentCounter = 0;

    public static String getNextStudentId(){
        return "S" + (++studentIdCounter);
    }

    public static String getNextCourseId(){
        return "C" + (++courseIdCounter);
    }

    public static String getNextTrainerId(){
        return "T" + (++trainerIdCounter);
    }

    public static String getNextEnrollmentId(){
        return "E" + (++enrollmentCounter);
    }
    
}
