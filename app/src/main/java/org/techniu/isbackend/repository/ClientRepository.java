package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.dto.model.ClientDto;
import org.techniu.isbackend.entity.Client;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {
    Client getByCode(String codeClient);
    List<Client> findAll();
}
