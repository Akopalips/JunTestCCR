package SpringProj.AdvicesAndExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TargetNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TargetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String targetNotFoundHandler(TargetNotFoundException e) {
        return e.getMessage();
    }
}