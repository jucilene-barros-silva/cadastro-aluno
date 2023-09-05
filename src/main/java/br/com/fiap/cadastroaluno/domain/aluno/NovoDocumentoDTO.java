package br.com.fiap.cadastroaluno.domain.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NovoDocumentoDTO {

    private Long id;
    @NotBlank(message = "O documento do aluno não pode estar em branco")
    @Size(min = 11, max = 11, message = "O documento do aluno deve ter 11 caracteres")
    @Pattern(regexp = "\\d{11}", message = "O documento do aluno deve conter apenas números")
    private String documento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public NovoDocumentoDTO() {
    }

    public NovoDocumentoDTO(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}