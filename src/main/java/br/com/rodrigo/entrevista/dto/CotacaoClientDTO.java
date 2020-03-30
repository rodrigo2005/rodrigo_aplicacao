package br.com.rodrigo.entrevista.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class CotacaoClientDTO {

    private Double cotacaoCompra;

    private Double cotacaoVenda;

    private String dataHoraCotacao;

    public Double getCotacaoCompra() {
        return cotacaoCompra;
    }

    public void setCotacaoCompra(Double cotacaoCompra) {
        this.cotacaoCompra = cotacaoCompra;
    }

    public Double getCotacaoVenda() {
        return cotacaoVenda;
    }

    public void setCotacaoVenda(Double cotacaoVenda) {
        this.cotacaoVenda = cotacaoVenda;
    }

    public String getDataHoraCotacao() {
        return dataHoraCotacao;
    }

    public void setDataHoraCotacao(String dataHoraCotacao) {
        this.dataHoraCotacao = dataHoraCotacao;
    }
}
