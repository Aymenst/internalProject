package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.StaffEconomicContractInformationUpdaterequest;
import org.techniu.isbackend.dto.mapper.StaffEconomicContractInformationMapper;
import org.techniu.isbackend.dto.model.StaffEconomicContractInformationDto;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.StaffEconomicContractInformationService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.StaffEconomicContractInformation;
import static org.techniu.isbackend.exception.ExceptionType.UPDATED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/staffEconomicContractInformation")
@CrossOrigin("*")
public class StaffEconomicContractInformationController {
    
    private StaffEconomicContractInformationService staffEconomicContractInformationService;
    private final MapValidationErrorService mapValidationErrorService;

    private final StaffEconomicContractInformationMapper staffEconomicContractInformationMapper = Mappers.getMapper(StaffEconomicContractInformationMapper.class);

    StaffEconomicContractInformationController(
            StaffEconomicContractInformationService staffEconomicContractInformationService,
            MapValidationErrorService mapValidationErrorService){
        this.staffEconomicContractInformationService = staffEconomicContractInformationService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid StaffEconomicContractInformationUpdaterequest staffEconomicContractInformationUpdaterequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        System.out.println(staffEconomicContractInformationUpdaterequest);
        StaffEconomicContractInformationDto staffEconomicContractInformationDto = staffEconomicContractInformationMapper.updateRequestToDto(staffEconomicContractInformationUpdaterequest);
        staffEconomicContractInformationService.update(staffEconomicContractInformationDto);

        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(StaffEconomicContractInformation, UPDATED)), HttpStatus.OK);
    }
    
}
