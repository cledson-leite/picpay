package springboot.desafio.picpay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springboot.desafio.picpay.dto.Response;
import springboot.desafio.picpay.exception.*;

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

    @ExceptionHandler(PicpayException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Response insufficientBalanceException( InsufficientBalanceException exception){
        String error = exception.getMessage();
        return new Response(false, null, error );
    }

    @ExceptionHandler(PicpayException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response internalServeErrorException( InternalServeErrorException exception){
        String error = exception.getMessage();
        return new Response(false, null, error );
    }

    @ExceptionHandler(PicpayException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Response invalidTransfer( InvalidTransfer exception){
        String error = exception.getMessage();
        return new Response(false, null, error );
    }

    @ExceptionHandler(PicpayException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Response invalidWallet( InvalidWallets exception){
        String error = exception.getMessage();
        return new Response(false, null, error );
    }

    @ExceptionHandler(PicpayException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response notificationException( NotificationException exception){
        String error = exception.getMessage();
        return new Response(false, null, error );
    }
}
