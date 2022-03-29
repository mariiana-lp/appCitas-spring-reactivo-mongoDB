package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.impl.citasReactivaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class CitasReactivaService {
    @Autowired
    private citasReactivaServiceImpl service;

   /* @Test
    void getAll() {
        Flux<citasDTOReactiva> citas = service.findAll();

        StepVerifier.create(citas)
                .expectNext()
    }*/

}
