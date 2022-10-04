package tech.julkrolon.SpringBootAngular.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
@Slf4j
public class ExceptionController {
    /**
     * Constraint violation exception handler
     *
     * @param ex ConstraintViolationException
     * @return List<ValidationError> - list of ValidationError built
     * from set of ConstraintViolation
     */
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String>
    handleConstraintViolation(ConstraintViolationException ex) {
        log.debug(
                "Constraint violation exception encountered: {}",
                ex.getConstraintViolations(),
                ex
        );
        return buildValidationErrors(ex.getConstraintViolations());
    }
    /**
     * Build list of ValidationError from set of ConstraintViolation
     *
     * @param violations Set<ConstraintViolation<?>> - Set
     *                   of parameterized ConstraintViolations
     * @return List<ValidationError> - list of validation errors
     */
    private List<String> buildValidationErrors(
            Set<ConstraintViolation<?>> violations) {
        return violations.
                stream().
                map(violation ->
                        "un Absurdo -> "+ violation.getMessage()).
                collect(Collectors.toList());
    }
}