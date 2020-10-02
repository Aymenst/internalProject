package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Leader;

public interface LeaderRepository  extends MongoRepository<Leader, String> {
}
