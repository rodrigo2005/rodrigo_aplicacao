package br.com.rodrigo.entrevista.domain;

import br.com.rodrigo.entrevista.dto.CotacaoClientDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Cotacao extends PanacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_requisicao")
    private LocalDateTime dataHoraRequisicao;

    @Column(name = "data_cotacao")
    private LocalDateTime dataCotacao;

    @Column(name = "contacao_compra")
    private Double cotacaoCompra;

    @Column(name = "cotacao_venda")
    private Double cotacaoVenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cotacao() {}

    public Cotacao(CotacaoClientDTO dto) {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        this.dataHoraRequisicao = LocalDateTime.now();
        this.dataCotacao = LocalDateTime.parse(dto.getDataHoraCotacao(), formatar);
        this.cotacaoCompra = dto.getCotacaoCompra();
        this.cotacaoVenda = dto.getCotacaoVenda();
    }
}
