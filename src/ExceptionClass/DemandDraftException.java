package ExceptionClass;

public class DemandDraftException extends Exception {

    public DemandDraftException(String message) {
        super("not a valid entry");
    }


}