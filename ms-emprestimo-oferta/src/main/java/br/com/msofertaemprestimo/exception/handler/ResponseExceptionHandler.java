package br.com.msofertaemprestimo.exception.handler;

import br.com.msofertaemprestimo.exception.ResponseRestException;
import br.com.msofertaemprestimo.exception.ValidationFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResponseExceptionHandler {
    /*
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerValidationFieldMethodArgumentNotValidException(MethodArgumentNotValidException exc){
        List<FieldError> fieldErrors = exc.getBindingResult().getFieldErrors();

        List<ValidationFieldException> response = new ArrayList<ValidationFieldException>();

        fieldErrors.forEach(e -> {
            String msgErro = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ValidationFieldException objErro = new ValidationFieldException(HttpStatus.BAD_REQUEST.value() ,e.getField(), msgErro);
            response.add(objErro);
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerException(Exception ex){
        ResponseRestException response = new ResponseRestException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

     */
}
