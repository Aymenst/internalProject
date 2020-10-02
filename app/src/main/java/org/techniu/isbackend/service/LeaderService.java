package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.Leader;

import java.util.List;

public interface LeaderService {
    Leader saveLeader(Leader leader);
    Leader updateLeader(Leader leader);
    ResponseEntity<?> deleteLeader(String leaderId);
    List<Leader> getAllLeader();
}
