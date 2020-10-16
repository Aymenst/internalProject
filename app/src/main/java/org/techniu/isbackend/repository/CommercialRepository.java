package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Commercial;

public interface CommercialRepository  extends MongoRepository<Commercial, String> {
}
