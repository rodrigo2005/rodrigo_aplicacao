package br.com.rodrigo.entrevista.dto;

import java.util.List;

public class CotacaoClientResponseDTO {

    private List<CotacaoClientDTO> value;

    public List<CotacaoClientDTO> getValue() {
        return value;
    }

    public void setValue(List<CotacaoClientDTO> value) {
        this.value = value;
    }
}
