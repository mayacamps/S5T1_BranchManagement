package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    public String NoResourceFoundException(NoResourceFoundException ex){
        return "error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String NullPointerException(NullPointerException ex){
        return "redirect:/api/v1/";
    }

}
