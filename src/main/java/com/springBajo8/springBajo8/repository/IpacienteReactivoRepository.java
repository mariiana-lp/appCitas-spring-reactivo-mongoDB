package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.pacienteDTOReactivo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface IpacienteReactivoRepository extends ReactiveMongoRepository<pacienteDTOReactivo, String> {

}
