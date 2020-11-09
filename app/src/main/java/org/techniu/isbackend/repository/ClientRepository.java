package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.techniu.isbackend.entity.Client;


import java.util.List;
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Client getByCode(String codeClient);
    Client getBy_id(String id);
    List<Client> findAll();
    Client findBy_id(String id);
    List<Client> findBySector1OrSector2OrSector3(String sector1,String sector2,String sector3);
}
