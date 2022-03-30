package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.pacienteDTOReactivo;
import com.springBajo8.springBajo8.repository.IpacienteReactivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class pacienteService {
    @Autowired
    private IpacienteReactivoRepository ipacienteReactivoRepository;

    public Mono<pacienteDTOReactivo> save(pacienteDTOReactivo pacienteDTOReactivo){
        return this.ipacienteReactivoRepository.save(pacienteDTOReactivo);
    }

    public Mono<pacienteDTOReactivo> findById(String id){
        return this.ipacienteReactivoRepository.findById(id);
    }

    public Mono<pacienteDTOReactivo> delete (String id){
        return this.ipacienteReactivoRepository.findById(id)
                .flatMap(p-> this.ipacienteReactivoRepository.deleteById(p.getId())
                        .thenReturn(p));
    }


}
