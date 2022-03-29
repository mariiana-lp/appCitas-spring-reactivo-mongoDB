package com.springBajo8.springBajo8.controller;

import com.springBajo8.springBajo8.service.IcitasReactivaService;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.web.citasReactivaResource;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

//@SpringBootTest
@ExtendWith(SpringExtension.class)
//@WebFluxTest(controllers = citasReactivaResource.class )
//@Import(IcitasReactivaService.class)
public class CitasReactivasControllerTest {

    @MockBean
    private IcitasReactivaService service;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("GET ALL /citasReactivas")
    public void getAll() throws Exception {
        citasDTOReactiva cita = new citasDTOReactiva();
        cita.setIdPaciente("xxx");
        cita.setNombrePaciente("Jess");
        cita.setApellidosPaciente("Lol");
        cita.setNombreMedico("Jinx");
        cita.setApellidosPaciente("Lol");
        cita.setEstadoReservaCita("activa");
        cita.setHoraReservaCita("80:00");
        cita.setFechaReservaCita(LocalDate.of(2020,12,12));

        List<citasDTOReactiva> list = new ArrayList<>();
        list.add(cita);

        Flux<citasDTOReactiva> flux = Flux.fromIterable(list);

        Mockito.when(service.findAll())
                .thenReturn(flux);

        webTestClient.get().uri("/citasReactivas")
                .exchange()
                .expectStatus().isOk();
    }


    @Test
    @DisplayName("GET BY PACIENT_ID /citasReactivas/{idPaciente}/byidPaciente")
    public void getById() throws Exception {

        citasDTOReactiva cita = new citasDTOReactiva();
        cita.setIdPaciente("xxx");
        cita.setNombrePaciente("Jess");
        cita.setApellidosPaciente("Lol");
        cita.setNombreMedico("Jinx");
        cita.setApellidosPaciente("Lol");
        cita.setEstadoReservaCita("activa");
        cita.setHoraReservaCita("80:00");
        cita.setFechaReservaCita(LocalDate.of(2020,12,12));

        List<citasDTOReactiva> list = new ArrayList<>();
        list.add(cita);

        Flux<citasDTOReactiva> flux = Flux.fromIterable(list);

        Mockito.when(service.findByIdPaciente("xxx"))
                        .thenReturn(flux);

        webTestClient.get().uri("/citasReactivas/{idPaciente}/byidPaciente", "xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(citasDTOReactiva.class);

        Mockito.verify(service, Mockito.times(1)).findByIdPaciente("xxx");
    }

}
