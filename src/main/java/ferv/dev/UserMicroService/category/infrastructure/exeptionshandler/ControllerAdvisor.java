package ferv.dev.UserMicroService.category.infrastructure.exeptionshandler;

import ferv.dev.UserMicroService.category.domain.exeptions.NotValidAgeExeption;
import ferv.dev.UserMicroService.category.infrastructure.exeptionshandler.exeptions.UserNotFound;
import ferv.dev.UserMicroService.commons.configurations.utils.constants.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = ErrorMessages.MESSAGE;

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<Map<String, String>> handleUserNotFound(UserNotFound exeption){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExeptionResponse.USER_NOT_FOUND.getMessage()));
    }

    @ExceptionHandler(NotValidAgeExeption.class)
    public ResponseEntity<Map<String, String>> handleInvalidAge(NotValidAgeExeption exeption){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExeptionResponse.NOT_VALID_AGE.getMessage()));
    }


}
