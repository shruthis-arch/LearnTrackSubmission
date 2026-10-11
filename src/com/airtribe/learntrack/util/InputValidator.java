package LearnTrack.src.com.airtribe.learntrack.util;

import LearnTrack.src.com.airtribe.learntrack.exceptions.InvalidInputException;

public class InputValidator {

    /*
    * To check if it is valid Name
    */
    public static void isValidName(String name) throws InvalidInputException{
        if(name == null || name.trim().isEmpty()){
            throw new InvalidInputException("Name should not be empty");
        }

        if(! name.matches("^[a-zA-z ]+$")){
            throw new InvalidInputException("Name should contain only alphabets. Please enter a valid Name");
        }
    }

    /*
    * To check if it is valid Email
    */
    public static void isValidEmail(String email) throws InvalidInputException{
        if(email == null || email.trim().isEmpty()){
            throw new InvalidInputException("Email should not be empty");
        }

        if(! email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
            throw new InvalidInputException("Invalid Email Id. Please enter a valid Email Id");
        }
    }

}
