package br.com.rodrigo.entrevista.resource;

import br.com.rodrigo.entrevista.dto.CotacaoDTO;
import br.com.rodrigo.entrevista.exception.StatusErrorException;
import br.com.rodrigo.entrevista.service.CotacaoService;
import br.com.rodrigo.entrevista.util.ApiUtil;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cotacao")
@Tag(name = "Cotação", description = "Serviços referêntes a cotação.")
public class CotacaoResource {

    @Inject
    CotacaoService cotacaoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{dataCotacao}")
    @Operation(description = "Retorna a Cotação de Compra e a Cotação de Venda da moeda Dólar para a data informada.\n" +
            "\n",summary = "Cotação do Dólar em uma determinada data")
    @Counted(name = "contadorRequisicaoCotacao", description = "Total de requisições")
    @Timed(name = "duracaoRequisicaoCotacao", description = "Duração da requisição", unit = MetricUnits.MILLISECONDS)
    @APIResponse(responseCode = "400", description = "Caso o usuário não exista")
    public List<CotacaoDTO> obterPorData(@PathParam("dataCotacao")  String dataCotacao) {
        if(ApiUtil.isFormatoDataInvalido(dataCotacao)) {
            throw  new StatusErrorException("A Data da cotação informada esta em um formato inválido.", Response.Status.BAD_REQUEST);
        }

     return cotacaoService.obterCotacao(dataCotacao);
    }
}