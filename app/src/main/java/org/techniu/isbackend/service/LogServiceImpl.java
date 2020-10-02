package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Log;
import org.techniu.isbackend.repository.LogRepository;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    private LogRepository logRepository;
    LogServiceImpl(LogRepository logRepository){
        this.logRepository = logRepository;
    }

    @Override
    public Log saveLog(Log log) {
        return logRepository.save(log);
    }
}
