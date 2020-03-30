package br.com.rodrigo.entrevista.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(description = "Dólar comercial (venda e compra) ",
                                title = "API - Cotação do dólar comercial",version = "0.0.1"))
@ApplicationPath("/api")
public class ConfigSwagger extends Application {
}
