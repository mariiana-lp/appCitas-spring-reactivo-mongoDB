package com.springBajo8.springBajo8.service.impl;

//import com.yoandypv.reactivestack.messages.domain.Message;
//import com.yoandypv.reactivestack.messages.repository.MessageRepository;
//import com.yoandypv.reactivestack.messages.service.MessageService;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.repository.IcitasReactivaRepository;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class citasReactivaServiceImpl implements IcitasReactivaService {

    @Autowired
    private IcitasReactivaRepository IcitasReactivaRepository;

    @Override
    public Mono<citasDTOReactiva> save(citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<citasDTOReactiva> delete(String id) {
        return this.IcitasReactivaRepository
                .findById(id)
                .flatMap(p -> this.IcitasReactivaRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<citasDTOReactiva> update(String id, citasDTOReactiva citasDTOReactiva) {
        return this.IcitasReactivaRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findByIdPaciente(String idPaciente) {
        return this.IcitasReactivaRepository.findByIdPaciente(idPaciente);
    }


    @Override
    public Flux<citasDTOReactiva> findAll() {
        return this.IcitasReactivaRepository.findAll();
    }

    @Override
    public Mono<citasDTOReactiva> findById(String id) {
        return this.IcitasReactivaRepository.findById(id);
    }

    @Override
    public Mono<citasDTOReactiva> cancelDate(String id, citasDTOReactiva citasDTOReactivas){
        return this.IcitasReactivaRepository.findById(id)
                .map((citasDTOReactiva1) -> {
                    if (!citasDTOReactivas.getEstadoReservaCita().equalsIgnoreCase("Cancelado")){
                        citasDTOReactivas.setEstadoReservaCita("Cancelado");
                    }
                    return citasDTOReactivas;
                }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<citasDTOReactiva> findAllByDateAndHour(String date, String hour){
        String [] fechaConvertida = date.split("-");
        return this.IcitasReactivaRepository.findAllByDateAndHour(LocalDate.of(Integer.parseInt(fechaConvertida[0]),
                Integer.parseInt(fechaConvertida[1]), Integer.parseInt(fechaConvertida[2])), hour);
    }

  /*  @Override
    public Mono<citasDTOReactiva> findDoctor(String id) {
        return this.IcitasReactivaRepository.findById(id)
                .map(cita -> {
                   return new citasDTOReactiva(id, cita.getNombreMedico(), cita.getApellidosMedico());
                }).switchIfEmpty(Mono.empty());
    }*/

    @Override
    public Mono<List<String>> findDoctor(String id) {
        //List<String> list = new ArrayList<>();
        return this.IcitasReactivaRepository.findById(id)
                .map(cita -> {
                    List<String> list = new ArrayList<>();
                    list.add(cita.getNombreMedico());
                    list.add(cita.getApellidosMedico());
                   return list;
                }).switchIfEmpty(Mono.empty());
    }

}
