package SpringProj.AdvicesAndExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TargetFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TargetFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String targetFoundHandler(TargetNotFoundException e) {
        return e.getMessage();
    }
}