package br.com.fiap.cadastroaluno.domain.aluno;

public class AlunoDTO {

    private Long id;
    private String idAluno;
    private String nome;
    private String documento;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String idAluno, String nome, String documento) {
        this.id = id;
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
