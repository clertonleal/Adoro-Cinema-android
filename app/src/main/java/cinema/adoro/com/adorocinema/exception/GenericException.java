package cinema.adoro.com.adorocinema.exception;

/**
 * Created by clertonleal on 18/10/14.
 * Adoro-Cinema-android
 */
public class GenericException extends Exception {

    public GenericException(Exception e){
        super(e);
    }

    public GenericException(String message){
        super(message);
    }

    public GenericException(String message, Exception e){
        super(message, e);
    }

}
