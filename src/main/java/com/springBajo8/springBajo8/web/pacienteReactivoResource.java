package com.springBajo8.springBajo8.web;

import com.springBajo8.springBajo8.domain.pacienteDTOReactivo;
import com.springBajo8.springBajo8.service.pacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/paciente")
public class pacienteReactivoResource {

    @Autowired
    private pacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<pacienteDTOReactivo> save (@RequestBody pacienteDTOReactivo pacienteDTOReactivo){
        return this.pacienteService.save(pacienteDTOReactivo);
    }

    @GetMapping("/{idPaciente}")
    private Mono<pacienteDTOReactivo> finfById(@PathVariable("idPaciente" ) String idPaciente){
        return this.pacienteService.findById(idPaciente);
    }
}
