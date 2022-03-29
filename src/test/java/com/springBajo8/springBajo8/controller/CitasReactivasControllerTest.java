package com.springBajo8.springBajo8.controller;


import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitasReactivasControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("GET ALL /citasReactivas")
    public void getAll() throws Exception {
        webTestClient.get().uri("/citasReactivas")
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @DisplayName("GET BY PACIENT_ID /citasReactivas/{idPaciente}/byidPaciente")
    public void getById() throws Exception {
        webTestClient.get().uri("/citasReactivas/{idPaciente}/byidPaciente", 6)
                .exchange()
                .expectStatus().isOk();
    }

    /*@Test
    @DisplayName("GET BY PACIENT_ID /citasReactivas/{idPaciente}/byidPaciente")
    public void getById() throws Exception {


        Flux<citasDTOReactiva> citasFlux = webTestClient.get()
                .uri("/citasReactivas/{idPaciente}/byidPaciente", "xxx")
                .exchange()
                .expectStatus().isOk()
                .returnResult(citasDTOReactiva.class).getResponseBody()
                .log();

        StepVerifier.create(citasFlux)
                .expectSubscription()
                .expectNextMatches(cita -> cita.getIdPaciente().equals("xxx"))
                .verifyComplete();
    }*/
}
