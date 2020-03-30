package br.com.rodrigo.entrevista.client;

import br.com.rodrigo.entrevista.dto.CotacaoClientResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/odata")
@RegisterRestClient
public interface CotacaoClient {

    @GET
    @Produces("application/json")
    @Path("CotacaoDolarDia(dataCotacao=@dataCotacao)")
    public CotacaoClientResponseDTO obterCotacaoPorData(
                                                 @QueryParam("@dataCotacao") String dataCotacao,
                                                 @QueryParam("$top") String top,
                                                 @QueryParam("$format") String format,
                                                 @QueryParam("$select") String select);


}
