package we_won.hackerton.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import we_won.hackerton.common.response.ApiUtils;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ApiUtils.ApiResult<?>> response(Throwable throwable, HttpStatus httpStatus) {
        return response(throwable.getMessage(), httpStatus);
    }

    private ResponseEntity<ApiUtils.ApiResult<?>> response(String message, HttpStatus httpStatus) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return new ResponseEntity<>(ApiUtils.error(message, httpStatus), headers, httpStatus);
    }

    @ExceptionHandler(
        NotFoundException.class
    )
    public ResponseEntity<?> handleNotFoundException(Exception e) {

        return response(e, HttpStatus.NOT_FOUND);
    }
}
