package br.com.rodrigo.entrevista.resource;

import br.com.rodrigo.entrevista.dto.CotacaoDTO;
import br.com.rodrigo.entrevista.service.CotacaoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public List<CotacaoDTO> obterPorData(@PathParam("dataCotacao") String dataCotacao) {
        if(dataCotacao == null || dataCotacao.isEmpty()) {
            throw new WebApplicationException("A Data da cotação que deseja obter deve ser informada",400);
        }
    return cotacaoService.obterCotacao(dataCotacao);
    }
}