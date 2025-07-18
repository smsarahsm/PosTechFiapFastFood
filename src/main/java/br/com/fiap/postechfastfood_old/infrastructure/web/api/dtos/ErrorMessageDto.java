package br.com.fiap.postechfastfood_old.infrastructure.web.api.dtos;

public record ErrorMessageDto(String message) {
    public ErrorMessageDto(String message) {
        this.message = message;
    }
}
