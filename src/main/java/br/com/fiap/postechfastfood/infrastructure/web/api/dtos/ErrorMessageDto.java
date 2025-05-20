package br.com.fiap.postechfastfood.infrastructure.web.api.dtos;

public record ErrorMessageDto(String message) {
    public ErrorMessageDto(String message) {
        this.message = message;
    }
}
