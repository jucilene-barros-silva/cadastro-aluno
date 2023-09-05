package br.com.fiap.cadastroaluno.service;

import br.com.fiap.cadastroaluno.domain.aluno.AlunoDTO;
import br.com.fiap.cadastroaluno.domain.aluno.NovoAlunoDTO;
import br.com.fiap.cadastroaluno.domain.aluno.NovoDocumentoDTO;
import br.com.fiap.cadastroaluno.domain.aluno.Aluno;
import br.com.fiap.cadastroaluno.exception.AlunoNotFoundException;
import br.com.fiap.cadastroaluno.exception.IdInvalidoException;
import br.com.fiap.cadastroaluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<AlunoDTO> listarAlunos(String nome) {
        List<Aluno> alunoList;
        if (nome != null) {
            alunoList = alunoRepository.findAllByNomeLike("%" + nome + "%");
        } else {
            alunoList = alunoRepository.findAll();
        }
        return alunoList.stream()
                .map(aluno -> new AlunoDTO(aluno.getId(), aluno.getIdAluno(), aluno.getNome(), aluno.getDocumento()))
                .collect(Collectors.toList());
    }

    @Override
    public AlunoDTO buscarAlunoPorId(Long id) {
        Aluno aluno = findAlunoById(id);
        return new AlunoDTO(aluno.getId(), aluno.getIdAluno(), aluno.getNome(), aluno.getDocumento());
    }

    private Aluno findAlunoById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado com o ID: " + id));
        return aluno;
    }

    @Override
    public AlunoDTO criar(NovoAlunoDTO novoAlunoDTO) {
        Aluno aluno = new Aluno(novoAlunoDTO.getIdAluno(), novoAlunoDTO.getNome(), novoAlunoDTO.getDocumento());
        Aluno savedAluno = alunoRepository.save(aluno);
        return new AlunoDTO(savedAluno.getId(), savedAluno.getIdAluno(), savedAluno.getNome(), savedAluno.getDocumento());
    }

    @Override
    public AlunoDTO atualizar(Long id, NovoAlunoDTO dataBaseNovoAlunoDTO) {
        Aluno aluno = findAlunoById(id);

        if (!aluno.getId().equals(dataBaseNovoAlunoDTO.getId())) {
            throw new IdInvalidoException("O ID no corpo da solicitação não corresponde ao ID do aluno.");
        }

        aluno.setIdAluno(dataBaseNovoAlunoDTO.getIdAluno());
        aluno.setNome(dataBaseNovoAlunoDTO.getNome());
        aluno.setDocumento(dataBaseNovoAlunoDTO.getDocumento());
        Aluno savedAluno = alunoRepository.save(aluno);
        return new AlunoDTO(savedAluno.getId(), savedAluno.getIdAluno(), savedAluno.getNome(), savedAluno.getDocumento());
    }

    @Override
    public AlunoDTO atualizarDocumento(Long id, NovoDocumentoDTO novoDocumentoDTO) {
        Aluno aluno = findAlunoById(id);

        if (!aluno.getId().equals(novoDocumentoDTO.getId())) {
            throw new IdInvalidoException("O ID no corpo da solicitação não corresponde ao ID do aluno.");
        }

        aluno.setDocumento(novoDocumentoDTO.getDocumento());
        Aluno savedAluno = alunoRepository.save(aluno);
        return new AlunoDTO(savedAluno.getId(), savedAluno.getIdAluno(), savedAluno.getNome(), savedAluno.getDocumento());
    }

    @Override
    public void deletarAluno(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNotFoundException("Aluno não encontrado com o ID: " + id));

        alunoRepository.delete(aluno);
    }
}
