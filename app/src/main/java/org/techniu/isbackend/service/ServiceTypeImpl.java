package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.techniu.isbackend.dto.mapper.ServiceTypeMapper;
import org.techniu.isbackend.dto.model.ServiceTypeDto;
import org.techniu.isbackend.entity.ServiceType;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.ServiceTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;

@Service
public class ServiceTypeImpl implements ServiceTypeService{
    private ServiceTypeRepository serviceTypeeRepository;
    private final ServiceTypeMapper serviceTypeeMapper = Mappers.getMapper(ServiceTypeMapper.class);
    ServiceTypeImpl(ServiceTypeRepository serviceTypeeRepository) {
        this.serviceTypeeRepository = serviceTypeeRepository;
    }
    @Override
    public void save(ServiceTypeDto serviceTypeeDto) {
        // save country if note existe
        serviceTypeeDto.setName(serviceTypeeDto.getName().toLowerCase());

        if (serviceTypeeDto.getName().contains(" ")) {
             throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }
        Optional<ServiceType>  serviceTypee= Optional.ofNullable(serviceTypeeRepository.findByName(serviceTypeeDto.getName()));
        if (serviceTypee.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }
        serviceTypeeRepository.save(serviceTypeeMapper.dtoToModel(serviceTypeeDto));
    }

    @Override
    public void update(ServiceTypeDto serviceTypeeDto) {
        // save country if note existe
        serviceTypeeDto.setName(serviceTypeeDto.getName().toLowerCase());
        if (serviceTypeeDto.getName().contains(" ")) {
            throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }
       Optional<ServiceType> serviceTypee1 = Optional.ofNullable(serviceTypeeRepository.findBy_id(serviceTypeeDto.getServiceTypeId()));
        if (!serviceTypee1.isPresent()) {
            throw exception(ExceptionType.ENTITY_NOT_FOUND);
        }
        Optional<ServiceType> serviceTypee2 = Optional.ofNullable(serviceTypeeRepository.findByName(serviceTypeeDto.getName()));

        if (serviceTypee2.isPresent() && !(serviceTypee1.get().getName().equals(serviceTypeeDto.getName())) ) {
            throw exception(DUPLICATE_ENTITY);
        }
         serviceTypeeRepository.save(serviceTypeeMapper.dtoToModel(serviceTypeeDto));
    }

    @Override
    public List<ServiceTypeDto> getAll() {
        // Get all actions
        List<ServiceType> serviceTypees = serviceTypeeRepository.findAll();
        // Create a list of all actions dto
        ArrayList<ServiceTypeDto> serviceTypeeDtos = new ArrayList<>();

        for (ServiceType serviceTypee : serviceTypees) {
            ServiceTypeDto serviceTypeeDto=serviceTypeeMapper.modelToDto(serviceTypee);
            serviceTypeeDtos.add(serviceTypeeDto);
        }
        return serviceTypeeDtos;
    }
    /**
     * delete Action
     *
     * @param id - id
     */
    @Override
    public void remove(String id) {
        Optional<ServiceType> action = Optional.ofNullable(serviceTypeeRepository.findBy_id(id));
        // If ServiceType doesn't exists
        if (!action.isPresent()) {
            throw exception(ENTITY_NOT_FOUND);
        }
        serviceTypeeRepository.deleteById(id);
    }


    /**
     * Returns a new RuntimeException
     *
     * @param exceptionType exceptionType
     * @param args  args
     * @return RuntimeException
     */
    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.ServiceType, exceptionType, args);
    }
}
