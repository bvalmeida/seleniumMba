package br.com.uniesp.test;

import br.com.uniesp.entidate.PessoaRequest;
import br.com.uniesp.entidate.PessoaResponse;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestTest {

    @BeforeEach
    void configApi(){
         baseURI= "https://reqres.in/api";
    }

    @Test
    @DisplayName("Validar GET OK")
    @Tag("contrato")
    void validaGet(){
        given()
                .and().log().all()
                .contentType(ContentType.JSON)
                .get("users?page={id}", 2)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/restGet.json"))
                .log().all();
    }

    @Test
    @DisplayName("Validar POST CREATE")
    @Tag("contrato")
    void validarPost(){

        PessoaRequest pessoaRequest = new PessoaRequest("breno","MBAIESP");

        PessoaResponse pr = given()
                .and().log().all()
                .contentType(ContentType.JSON)
                .body(pessoaRequest)
                .when()
                .post("users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/restPost.json"))
                .log().all().extract().response().as(PessoaResponse.class);

        Assertions.assertNotNull(pr);
        Assertions.assertNotNull(pr.getId());
        Assertions.assertEquals(pessoaRequest.getNome(), pr.getNome());
    }

    @Test
    @DisplayName("Validar PUT OK")
    @Tag("contrato")
    void validarPut(){

        PessoaRequest pessoaRequest = new PessoaRequest("joão", "MBAIESP");

        given()
                .and().log().all()
                .contentType(ContentType.JSON)
                .body(pessoaRequest)
                .when()
                .put("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/restPut.json"))
                .log().all();
    }

    @Test
    @DisplayName("Validade DELETE NO CONTENT")
    @Tag("contrato")
    void validarDelete(){
        given()
                .and().log().all()
                .contentType(ContentType.JSON)
                .delete("users/2")
                .then()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .and().log().all();
    }
}
