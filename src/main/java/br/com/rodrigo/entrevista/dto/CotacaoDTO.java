package br.com.rodrigo.entrevista.dto;

import br.com.rodrigo.entrevista.domain.Cotacao;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

public class CotacaoDTO {

    @Schema(description = "Hora em que o usuário realizou a requisição.")
    private LocalDateTime dataHoraRequisicao;

    @Schema(description = "Data em que a cotação foi cadastrada.")
    private LocalDateTime dataCotacao;

    @Schema(description = "Valor da cotação para compra")
    private Double cotacaoCompra;

    @Schema(description = "Valor da cotação para compra")
    private Double cotacaoVenda;

    public CotacaoDTO(Cotacao cotacao) {
        this.dataHoraRequisicao = cotacao.getDataHoraRequisicao();
        this.dataCotacao = cotacao.getDataCotacao();
        this.cotacaoCompra = cotacao.getCotacaoCompra();
        this.cotacaoVenda = cotacao.getCotacaoVenda();
    }

    public LocalDateTime getDataHoraRequisicao() {
        return dataHoraRequisicao;
    }

    public void setDataHoraRequisicao(LocalDateTime dataHoraRequisicao) {
        this.dataHoraRequisicao = dataHoraRequisicao;
    }

    public LocalDateTime getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(LocalDateTime dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

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
}
