package br.com.rodrigo.entrevista.service;

import br.com.rodrigo.entrevista.client.CotacaoClient;
import br.com.rodrigo.entrevista.domain.Cotacao;
import br.com.rodrigo.entrevista.dto.CotacaoClientResponseDTO;
import br.com.rodrigo.entrevista.dto.CotacaoClientDTO;
import br.com.rodrigo.entrevista.dto.CotacaoDTO;
import br.com.rodrigo.entrevista.exception.NegocioException;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.net.UnknownHostException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CotacaoService {

    @Inject
    @RestClient
    CotacaoClient cotacaoClient;

    public List<CotacaoClientDTO> obterCotacaoClient(String dataCotacao, String top, String format, String select) {
        CotacaoClientResponseDTO response =  cotacaoClient.obterCotacaoPorData(dataCotacao, top, format, select);
        return response.getValue().stream().map(dto -> dto).collect(Collectors.toList());
    }

    public List<CotacaoDTO> obterCotacao(String dataCotacao) {
        List<CotacaoClientDTO> response = obterCotacaoClient("'"+dataCotacao+"'"
                ,"1","json","cotacaoCompra,cotacaoVenda,dataHoraCotacao");
        return response.stream().map(cotacao -> salvar(cotacao)).collect(Collectors.toList());
    }

    @Transactional
    public CotacaoDTO salvar(CotacaoClientDTO cotacaoClient){
        Cotacao cotacao = new Cotacao(cotacaoClient);
        cotacao.persist();
        return new CotacaoDTO(cotacao);
    }

}
