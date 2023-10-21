package GasStationsAPI.GasStationsAPI.error;

public class InvalidFuelTypeException extends RuntimeException{

    public InvalidFuelTypeException() {
        super();
    }

    public InvalidFuelTypeException(String message) {
        super(message);
    }

    public InvalidFuelTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFuelTypeException(Throwable cause) {
        super(cause);
    }

    protected InvalidFuelTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
