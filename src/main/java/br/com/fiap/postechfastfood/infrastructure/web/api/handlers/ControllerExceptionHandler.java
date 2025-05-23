package br.com.fiap.postechfastfood.infrastructure.web.api.handlers;

import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ErrorDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.dtos.ErrorMessageDto;
import br.com.fiap.postechfastfood.infrastructure.web.api.exceptions.CpfCadastradoException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { CpfCadastradoException.class })
    protected ErrorDto handleCpfCadastradoException(CpfCadastradoException ex, HttpServletRequest req) {
        List<ErrorMessageDto> errors = new ArrayList<>();
        ErrorMessageDto error = new ErrorMessageDto(ex.getMessage());
        errors.add(error);
        return new ErrorDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                errors,
                req.getServletPath());
    }
}
