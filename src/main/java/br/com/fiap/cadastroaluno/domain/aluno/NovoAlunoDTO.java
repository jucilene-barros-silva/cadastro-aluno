package br.com.fiap.cadastroaluno.domain.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class NovoAlunoDTO {

    private Long id;
    @NotBlank(message = "O ID do aluno não pode estar em branco")
    @Size(max = 100, message = "O ID do aluno não pode ter mais de 100 caracteres")
    @Pattern(regexp = "RM\\d{1,100}", message = "O idAluno deve estar no formato RM seguido de números, com no máximo 100 caracteres")
    private String idAluno;

    @NotBlank(message = "O nome do aluno não pode estar em branco")
    @Size(max = 255, message = "O nome do aluno não pode ter mais de 255 caracteres")
    private String nome;

    @NotBlank(message = "O documento do aluno não pode estar em branco")
    @Size(min = 11, max = 11, message = "O documento do aluno deve ter 11 caracteres")
    @Pattern(regexp = "\\d{11}", message = "O documento do aluno deve conter apenas números")
    private String documento;

    public NovoAlunoDTO() {
    }

    public NovoAlunoDTO(String idAluno, String nome, String documento) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.documento = documento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(String idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}