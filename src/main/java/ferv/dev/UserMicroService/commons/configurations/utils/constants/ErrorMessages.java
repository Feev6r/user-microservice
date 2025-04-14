package ferv.dev.UserMicroService.commons.configurations.utils.constants;

public final class ErrorMessages {
    private ErrorMessages() {
        throw new IllegalStateException("Utility class");
    }

    public static final String USER_EXEPTION_MESSAGE = "User was not found";
    public static final String MESSAGE = "Message";
    public static final String AGE_MESSAGE_EXEPTION = "The user has to be at least 18 years old";
    public static final String USERNAME_FORMAT_MESSAGE_EXEPTION = "Invalid user id format";
    public static final String USERNAME_MESSAGE_EXEPTION = "Username not found";


}
