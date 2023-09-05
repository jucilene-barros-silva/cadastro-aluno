package br.com.fiap.cadastroaluno.controller;

import br.com.fiap.cadastroaluno.domain.aluno.AlunoDTO;
import br.com.fiap.cadastroaluno.domain.aluno.NovoAlunoDTO;
import br.com.fiap.cadastroaluno.domain.aluno.NovoDocumentoDTO;
import br.com.fiap.cadastroaluno.error.ErrorResponse;
import br.com.fiap.cadastroaluno.exception.*;
import br.com.fiap.cadastroaluno.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

@GetMapping
public ResponseEntity<?> getAlunos(
        @RequestParam(required = false, defaultValue = "") String nome) {
    try {
        List<AlunoDTO> alunos = alunoService.listarAlunos(nome);
        return ResponseEntity.ok(alunos);
    } catch (DadosInvalidosException e) {
        ErrorResponse errorResponse = new ErrorResponse("Dados inválidos", List.of(e.getMessage()));
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

    @GetMapping("{id}")
    public ResponseEntity<?> getAlunoById(
            @PathVariable(name = "id") Long id) {
        try {
            AlunoDTO alunoDTO = alunoService.buscarAlunoPorId(id);
            return ResponseEntity.ok(alunoDTO);
        } catch (IdInvalidoException e) {
            ErrorResponse errorResponse = new ErrorResponse("ID inválido", List.of(e.getMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (AlunoNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse("Aluno não encontrado", List.of(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createAluno(
            @Valid @RequestBody NovoAlunoDTO novoAlunoDTO) {
        try {
            AlunoDTO alunoDTO = alunoService.criar(novoAlunoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
        } catch (DadosInvalidosException e) {
            ErrorResponse errorResponse = new ErrorResponse("Dados inválidos", List.of(e.getMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateAluno(
            @PathVariable Long id,
            @Valid @RequestBody NovoAlunoDTO novoAlunoDTO) {
        try {
            if (!id.equals(novoAlunoDTO.getId())) {
                ErrorResponse errorResponse = new ErrorResponse("IDs não coincidem",
                        List.of("O ID no path não corresponde ao ID no corpo da solicitação."));
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            AlunoDTO alunoDTO = alunoService.atualizar(id, novoAlunoDTO);
            return ResponseEntity.ok(alunoDTO);
        } catch (IdInvalidoException e) {
            ErrorResponse errorResponse = new ErrorResponse("ID inválido", List.of(e.getMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (AlunoNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse("Aluno não encontrado", List.of(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (DadosInvalidosException e) {
            ErrorResponse errorResponse = new ErrorResponse("Dados inválidos", List.of(e.getMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PatchMapping("{id}/documento")
    public ResponseEntity<?> updateDocumentoDoAluno(
            @PathVariable Long id,
            @Valid @RequestBody NovoDocumentoDTO novoDocumentoDTO) {
        try {
            if (!id.equals(novoDocumentoDTO.getId())) {
                ErrorResponse errorResponse = new ErrorResponse("IDs não coincidem",
                        List.of("O ID no path não corresponde ao ID no corpo da solicitação."));
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            AlunoDTO alunoDTO = alunoService.atualizarDocumento(id, novoDocumentoDTO);
            return ResponseEntity.ok(alunoDTO);
        } catch (IdInvalidoException e) {
            ErrorResponse errorResponse = new ErrorResponse("ID inválido", List.of(e.getMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (AlunoNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse("Aluno não encontrado", List.of(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } catch (DadosInvalidosException e) {
            ErrorResponse errorResponse = new ErrorResponse("Dados inválidos", List.of(e.getMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteAluno(
            @PathVariable Long id) {
        try {
            alunoService.deletarAluno(id);
            return ResponseEntity.noContent().build();
        } catch (IdInvalidoException e) {
            ErrorResponse errorResponse = new ErrorResponse("ID inválido", List.of(e.getMessage()));
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (AlunoNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse("Aluno não encontrado", List.of(e.getMessage()));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}

