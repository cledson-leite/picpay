package springboot.desafio.picpay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springboot.desafio.picpay.dto.Response;
import springboot.desafio.picpay.exception.DuplicateWalletException;
import springboot.desafio.picpay.exception.PicpayException;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleValidationsExceptions(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
        String error = bindingResult.getAllErrors().getFirst().getDefaultMessage();
        return new Response(false, null, error );
    }

    @ExceptionHandler(PicpayException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response duplicatedExceptions( DuplicateWalletException exception){
        String error = exception.getMessage();
        return new Response(false, null, error );
    }
}
