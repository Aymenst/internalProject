package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.techniu.isbackend.dto.mapper.CommercialOperationMapper;
import org.techniu.isbackend.dto.model.CommercialOperationDto;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.ClientRepository;
import org.techniu.isbackend.repository.CommercialOperationRepository;
import org.techniu.isbackend.repository.CommercialOperationStatusRepository;
import org.techniu.isbackend.repository.ServiceTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;

@Service
public class CommercialOperationServiceImpl implements CommercialOperationService{
    private CommercialOperationRepository commercialOperationRepository;
    private ClientRepository clientRepository;
    private ServiceTypeService serviceTypeService;
    private ServiceTypeRepository serviceTypeRepository;
    private CommercialOperationStatusRepository commercialOperationStatusRepository;
    private final CommercialOperationMapper commercialOperationMapper = Mappers.getMapper(CommercialOperationMapper.class);
    CommercialOperationServiceImpl(CommercialOperationRepository commercialOperationRepository,
                                   CommercialOperationStatusRepository commercialOperationStatusRepository,
                                   ClientRepository clientRepository, ServiceTypeService serviceTypeService, ServiceTypeRepository serviceTypeRepository) {
        this.commercialOperationRepository = commercialOperationRepository;
        this.clientRepository = clientRepository;
        this.commercialOperationStatusRepository = commercialOperationStatusRepository;
        this.serviceTypeService = serviceTypeService;
        this.serviceTypeRepository = serviceTypeRepository;
    }
    @Override
    public void save(CommercialOperationDto commercialOperationDto) {
        // save country if note existe
        commercialOperationDto.setName(commercialOperationDto.getName().toLowerCase());
       Client client = clientRepository.getBy_id(commercialOperationDto.getClientId());
        CommercialOperationStatus commercialOperationStatus = commercialOperationStatusRepository.findBy_id(commercialOperationDto.getStateId());
        int len = this.getAll().size();
        String code;
        //City city=cityRepository.findCityBy_id(cityId);
       // String country = city.getStateCountry().getCountry().getCountryName().length() > 3 ? city.getStateCountry().getCountry().getCountryName().substring(0,3).toUpperCase() : city.getStateCountry().getCountry().getCountryName().toUpperCase();
        if (len < 9) {
            len+=1;
            code = "-00" + len;
            commercialOperationDto.setCode(code);
        }
        if (len < 99) {
            len+=1;
            code = "-0" + len;
            commercialOperationDto.setCode(code);
        } else {
            len+=1;
            code =  "-" + len;
            commercialOperationDto.setCode(code);
        }

        if (commercialOperationDto.getName().contains(" ")) {
             throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }
        Optional<CommercialOperation>  commercialOperation= Optional.ofNullable(commercialOperationRepository.findByName(commercialOperationDto.getName()));
        if (commercialOperation.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }
        Optional<CommercialOperation>  commercialOperation1= Optional.ofNullable(commercialOperationRepository.findByCode(commercialOperationDto.getCode()));
        if (commercialOperation1.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }
        ArrayList<ServiceType> serviceTypes = new ArrayList<>();
        List<String> serviceTypesIds = commercialOperationDto.getServiceTypeId();
        for (String serviceId : serviceTypesIds) {
            serviceTypes.add(serviceTypeRepository.findBy_id(serviceId));
        }
        CommercialOperation commercialOperation3 = commercialOperationMapper.dtoToModel(commercialOperationDto);
        commercialOperation3.setClient(client);
        commercialOperation3.setState(commercialOperationStatus);
        commercialOperation3.setServiceType(serviceTypes);
        commercialOperationRepository.save(commercialOperation3);
    }

    @Override
    public void update(CommercialOperationDto commercialOperationDto) {
        // save country if note existe
        commercialOperationDto.setName(commercialOperationDto.getName().toLowerCase());
        if (commercialOperationDto.getName().contains(" ")) {
            throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }
       Optional<CommercialOperation> commercialOperation1 = Optional.ofNullable(commercialOperationRepository.findBy_id(commercialOperationDto.getCommercialOperationId()));
        if (!commercialOperation1.isPresent()) {
            throw exception(ExceptionType.ENTITY_NOT_FOUND);
        }
        Optional<CommercialOperation> commercialOperation2 = Optional.ofNullable(commercialOperationRepository.findByName(commercialOperationDto.getName()));

        if (commercialOperation2.isPresent() && !(commercialOperation1.get().getName().equals(commercialOperationDto.getName())) ) {
            throw exception(DUPLICATE_ENTITY);
        }
        Optional<CommercialOperation> commercialOperation3 = Optional.ofNullable(commercialOperationRepository.findByCode(commercialOperationDto.getCode()));
        if (commercialOperation3.isPresent() && !(commercialOperation1.get().getCode().equals(commercialOperationDto.getCode())) ) {
            throw exception(DUPLICATE_ENTITY);
        }
         commercialOperationRepository.save(commercialOperationMapper.dtoToModel(commercialOperationDto));
    }

    @Override
    public List<CommercialOperationDto> getAll() {
        // Get all commercialOperations
        List<CommercialOperation> commercialOperations = commercialOperationRepository.findAll();
        // Create a list of all commercialOperation dto
        ArrayList<CommercialOperationDto> commercialOperationDtos = new ArrayList<>();

        for (CommercialOperation commercialOperation : commercialOperations) {
            CommercialOperationDto commercialOperationDto = commercialOperationMapper.modelToDto(commercialOperation);
            commercialOperationDto.setClientName(commercialOperation.getClient().getName());
            //commercialOperationDto.set(commercialOperation.getState().getPercentage());
            commercialOperationDto.setCountryName(commercialOperation.getClient().getAddress().getCity().getStateCountry().getCountry().getCountryName());
            ArrayList<String> serviceTypes = new ArrayList<>();
            if (commercialOperation.getServiceType() != null){
               int a= commercialOperation.getServiceType().size();
                for (ServiceType servicetype : commercialOperation.getServiceType()) {
                    serviceTypes.add(servicetype.getName());
                    a=a-1;
                    if(a>0) {
                        serviceTypes.add(" , ");
                    }

                }
            commercialOperationDto.setServiceTypeName(serviceTypes);
                commercialOperationDto.setStateName(commercialOperation.getState().getName());
        }
            commercialOperationDtos.add(commercialOperationDto);
        }
        return commercialOperationDtos;
    }
    /**
     * delete Action
     *
     * @param id - id
     */
    @Override
    public void remove(String id) {
        Optional<CommercialOperation> action = Optional.ofNullable(commercialOperationRepository.findBy_id(id));
        // If CommercialOperation doesn't exists
        if (!action.isPresent()) {
            throw exception(ENTITY_NOT_FOUND);
        }
        commercialOperationRepository.deleteById(id);
    }


    /**
     * Returns a new RuntimeException
     *
     * @param exceptionType exceptionType
     * @param args  args
     * @return RuntimeException
     */
    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.CommercialOperation, exceptionType, args);
    }
}
