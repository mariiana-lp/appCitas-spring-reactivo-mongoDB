package com.springBajo8.springBajo8.repository;

//import com.yoandypv.reactivestack.messages.domain.Message;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface IcitasReactivaRepository extends ReactiveMongoRepository<citasDTOReactiva, String> {
    Flux<citasDTOReactiva> findByIdPaciente(String idPaciente);
    @Query(value = "{ fechaReservaCita: ?0, horaReservaCita: ?1}")
    public Flux<citasDTOReactiva> findAllByDateAndHour(LocalDate date, String hour);
}
