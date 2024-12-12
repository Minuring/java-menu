package menu.error;

public abstract class BusinessException extends IllegalArgumentException {

    protected ErrorType errorType;

    public BusinessException(ErrorType errorType) {
        super(errorType.message());
        this.errorType = errorType;
    }

    public BusinessException(ErrorType errorType, Object... args) {
        super(errorType.message(args));
        this.errorType = errorType;
    }
}
