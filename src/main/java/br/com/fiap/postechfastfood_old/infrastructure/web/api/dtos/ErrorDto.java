package br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorDto(
        LocalDateTime timestamp,
        Integer status,
        String message,
        List<?> errors,
        String path) {

    public ErrorDto(LocalDateTime timestamp, Integer status, String message, String path) {
        this(timestamp, status, message, List.of(), path);
    }
}
