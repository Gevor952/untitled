package homework.medical_center;

public class TimeNotAllowedException extends Exception
{
    public TimeNotAllowedException() {
    }

    public TimeNotAllowedException(String message) {
        super(message);
    }

    public TimeNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeNotAllowedException(Throwable cause) {
        super(cause);
    }

    public TimeNotAllowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
