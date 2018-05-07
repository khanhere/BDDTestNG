package testng1.pageobjects;

public class WrongPageException extends RuntimeException {
    public WrongPageException (String message)
    {
        super(message);
    }
}
