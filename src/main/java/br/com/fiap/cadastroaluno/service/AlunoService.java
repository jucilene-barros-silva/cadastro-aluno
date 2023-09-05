package br.com.fiap.cadastroaluno.service;

import br.com.fiap.cadastroaluno.domain.aluno.AlunoDTO;
import br.com.fiap.cadastroaluno.domain.aluno.NovoAlunoDTO;
import br.com.fiap.cadastroaluno.domain.aluno.NovoDocumentoDTO;

import java.util.List;

public interface AlunoService {

    List<AlunoDTO> listarAlunos(String nome);
    AlunoDTO buscarAlunoPorId(Long id);
    AlunoDTO criar(NovoAlunoDTO novoAlunoDTO);
    AlunoDTO atualizar(Long id, NovoAlunoDTO novoAlunoDTO);
    AlunoDTO atualizarDocumento(Long id, NovoDocumentoDTO novoDocumentoDTO);
    void deletarAluno(Long id);

}
