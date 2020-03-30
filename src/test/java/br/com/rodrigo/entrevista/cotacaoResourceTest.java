package br.com.rodrigo.entrevista;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class cotacaoResourceTest {

    @Test
    public void testSucessoCosultaCotacao() {
        given()
          .when().get("/api/cotacao/03-25-2020")
          .then()
             .statusCode(200)
             .body(notNullValue());
    }

    @Test
    public void testDataInvalida() {
        given()
                .when().get("/api/cotacao/13-25-2020")
                .then()
                .statusCode(400);
    }

    @Test
    public void testDataNaoInformada() {
        given()
                .when().get("/api/cotacao/")
                .then()
                .statusCode(404);
    }

    public void testApiBancoCentralIndisponivel() {
        //TODO - Falta implementar para esperar receber um exception.
    }



}