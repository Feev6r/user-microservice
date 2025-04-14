package ferv.dev.UserMicroService.category.infrastructure.exeptionshandler;

import ferv.dev.UserMicroService.commons.configurations.utils.constants.ErrorMessages;

public enum ExeptionResponse {

    USER_NOT_FOUND(ErrorMessages.USER_EXEPTION_MESSAGE),
    NOT_VALID_AGE(ErrorMessages.AGE_MESSAGE_EXEPTION);

    private final String message;

    ExeptionResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
