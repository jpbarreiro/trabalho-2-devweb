package com.jpbarreiro.trabalho2devweb.dto;

import com.jpbarreiro.trabalho2devweb.model.Turma;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurmaDTO {
    private Long id;
    private String nome;
    private Long professorId;

    public TurmaDTO() {
    }

    public TurmaDTO(Long id, String nome, Long professorId) {
        this.id = id;
        this.nome = nome;
        this.professorId = professorId;
    }

    public TurmaDTO(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.professorId = turma.getProfessor() != null ? turma.getProfessor().getId() : null;
    }
}
