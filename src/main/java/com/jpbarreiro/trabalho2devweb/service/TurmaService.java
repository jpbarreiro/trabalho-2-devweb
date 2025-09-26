package com.jpbarreiro.trabalho2devweb.service;

import com.jpbarreiro.trabalho2devweb.dto.TurmaDTO;
import com.jpbarreiro.trabalho2devweb.exception.ResourceNotFoundException;
import com.jpbarreiro.trabalho2devweb.model.Professor;
import com.jpbarreiro.trabalho2devweb.model.Turma;
import com.jpbarreiro.trabalho2devweb.repository.ProfessorRepository;
import com.jpbarreiro.trabalho2devweb.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    private final TurmaRepository turmaRepository;
    private final ProfessorRepository professorRepository;

    public TurmaService(TurmaRepository turmaRepository, ProfessorRepository professorRepository) {
        this.turmaRepository = turmaRepository;
        this.professorRepository = professorRepository;
    }

    public TurmaDTO create(TurmaDTO dto) {
        if (dto.getProfessorId() == null) {
            throw new IllegalArgumentException("É necessário informar o professor da turma");
        }

        Professor professor = professorRepository.findById(dto.getProfessorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Professor não encontrado com id " + dto.getProfessorId()));

        Turma turma = new Turma();
        turma.setProfessor(professor);
        Turma saved = turmaRepository.save(turma);
        return new TurmaDTO(saved);
    }

    public void delete(Long id) {
        if (!turmaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Turma não encontrada com id " + id);
        }
        turmaRepository.deleteById(id);
    }

    public TurmaDTO findById(Long id) {
        Turma turma = turmaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada com id " + id));
        return new TurmaDTO(turma);
    }

    public List<TurmaDTO> findAll() {
        return turmaRepository.findAll()
                .stream()
                .map(TurmaDTO::new)
                .collect(Collectors.toList());
    }
}
