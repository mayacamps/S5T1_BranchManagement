package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
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

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return "redirect:/api/v1/";
    }
}
