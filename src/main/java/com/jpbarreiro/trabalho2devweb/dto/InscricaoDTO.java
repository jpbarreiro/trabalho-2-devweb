package com.jpbarreiro.trabalho2devweb.dto;

import com.jpbarreiro.trabalho2devweb.model.Inscricao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InscricaoDTO {
    private Long id;
    private Long alunoId;
    private Long turmaId;

    public InscricaoDTO() {
    }

    public InscricaoDTO(Long id, Long alunoId, Long turmaId) {
        this.id = id;
        this.alunoId = alunoId;
        this.turmaId = turmaId;
    }

    public InscricaoDTO(Inscricao inscricao) {
        this.id = inscricao.getId();
        this.alunoId = inscricao.getAluno().getId();
        this.turmaId = inscricao.getTurma().getId();
    }
}
