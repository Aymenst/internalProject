package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Leader;
import org.techniu.isbackend.repository.LeaderRepository;

import java.util.List;
@Service
@Transactional
public class LeaderServiceImpl implements LeaderService {
    private LeaderRepository leaderRepository;
    LeaderServiceImpl(LeaderRepository leaderRepository){
        this.leaderRepository = leaderRepository;
    }
    @Override
    public Leader saveLeader(Leader leader) {
        return leaderRepository.save(leader);
    }

    @Override
    public Leader updateLeader(Leader leader) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteLeader(String leaderId) {
        return null;
    }

    @Override
    public List<Leader> getAllLeader() {
        return leaderRepository.findAll();
    }
}
