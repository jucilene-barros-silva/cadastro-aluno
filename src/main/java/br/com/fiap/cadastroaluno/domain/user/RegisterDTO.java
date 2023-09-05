package br.com.fiap.cadastroaluno.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
