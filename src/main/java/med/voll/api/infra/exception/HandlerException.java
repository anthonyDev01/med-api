package med.voll.api.infra.exception;

import med.voll.api.infra.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handlerMedicoNotFound(UserNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerFieldNull(MethodArgumentNotValidException exception){
        List<FieldError> errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());
    }


    private record DadosErroValidacao(String campo, String mensagem){
        public DadosErroValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
