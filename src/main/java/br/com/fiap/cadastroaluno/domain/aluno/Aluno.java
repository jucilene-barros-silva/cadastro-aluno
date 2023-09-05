package br.com.fiap.cadastroaluno.domain.aluno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_aluno")
    private String idAluno;

    @Column(name = "nome")
    private String nome;

    @Column(name = "documento")
    private String documento;

    public Aluno(){}

    public Aluno(String idAluno, String nome, String documento) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.documento = documento;
    }

    public Aluno(NovoAlunoDTO novoAlunoDTO) {
        this.idAluno = novoAlunoDTO.getIdAluno();
        this.nome = novoAlunoDTO.getNome();
        this.documento = novoAlunoDTO.getDocumento();
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

    public void setDocumento(String documento) {this.documento = documento;
    }
}

