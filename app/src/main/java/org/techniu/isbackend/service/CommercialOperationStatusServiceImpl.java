package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.techniu.isbackend.dto.mapper.CommercialOperationStatusMapper;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.entity.CommercialOperationStatus;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.CommercialOperationStatusRepository;
import static org.techniu.isbackend.exception.EntityType.*;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;

@Service
public class CommercialOperationStatusServiceImpl implements CommercialOperationStatusService{
    private CommercialOperationStatusRepository commercialOperationStatusRepository;
    private final CommercialOperationStatusMapper commercialOperationStatusMapper = Mappers.getMapper(CommercialOperationStatusMapper.class);
    CommercialOperationStatusServiceImpl(CommercialOperationStatusRepository commercialOperationStatusRepository) {
        this.commercialOperationStatusRepository = commercialOperationStatusRepository;
    }
    @Override
    public CommercialOperationStatus save(CommercialOperationStatusDto commercialOperationStatusDto) {
        // save country if note existe
        commercialOperationStatusDto.setName(commercialOperationStatusDto.getName().toLowerCase());

        List<CommercialOperationStatus> CommercialOperationStatus = commercialOperationStatusRepository.findByName(commercialOperationStatusDto.getName());
        if (commercialOperationStatusDto.getName().contains(" ")) {
             throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }
        for (CommercialOperationStatus commercialOperationStatus : CommercialOperationStatus) {
            if(commercialOperationStatus.getName().equals(commercialOperationStatusDto.getName().toLowerCase())){
                throw exception(DUPLICATE_ENTITY);
            }
        }
        return commercialOperationStatusRepository.save(commercialOperationStatusMapper.dtoToModel(commercialOperationStatusDto));
    }


    @Override
    public List<CommercialOperationStatusDto> getAll() {
        // Get all actions
        List<CommercialOperationStatus> commercialOperationStatuss = commercialOperationStatusRepository.findAll();
        // Create a list of all actions dto
        ArrayList<CommercialOperationStatusDto> commercialOperationStatusDtos = new ArrayList<>();

        for (CommercialOperationStatus commercialOperationStatus : commercialOperationStatuss) {
            CommercialOperationStatusDto commercialOperationStatusDto=commercialOperationStatusMapper.modelToDto(commercialOperationStatus);
            commercialOperationStatusDtos.add(commercialOperationStatusDto);
        }
        return commercialOperationStatusDtos;
    }

    /**
     * Returns a new RuntimeException
     *
     * @param exceptionType exceptionType
     * @param args  args
     * @return RuntimeException
     */
    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.CommercialOperationStatus, exceptionType, args);
    }
}
