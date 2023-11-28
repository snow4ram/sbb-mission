package lionpostproject.hjs.user.controller;


import lionpostproject.hjs.user.exception.ErrorCode;
import lionpostproject.hjs.user.exception.SignInException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ApiExceptionController {


    @ExceptionHandler
    public ResponseEntity<ErrorCode> signInExHandle(SignInException ex){
        ErrorCode errorCode = new ErrorCode("q", ex.getMessage());
        return new ResponseEntity<>(errorCode, HttpStatus.BAD_REQUEST);

    }


}
