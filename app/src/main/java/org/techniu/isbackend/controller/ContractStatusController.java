package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.ContractStatusAddrequest;
import org.techniu.isbackend.controller.request.ContractStatusUpdaterequest;
import org.techniu.isbackend.dto.mapper.ContractStatusMapper;
import org.techniu.isbackend.dto.model.ContractStatusDto;
import org.techniu.isbackend.entity.ContractStatus;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.ContractStatusService;
import static org.techniu.isbackend.exception.EntityType.ContractStatus;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/contractStatus")
@CrossOrigin("*")
public class ContractStatusController {

    private ContractStatusService contractStatusService;
    private final MapValidationErrorService mapValidationErrorService;
    private final ContractStatusMapper contractStatusMapper = Mappers.getMapper(ContractStatusMapper.class);


    public ContractStatusController(ContractStatusService contractStatusService, MapValidationErrorService mapValidationErrorService) {
        this.contractStatusService = contractStatusService;
        this.mapValidationErrorService = mapValidationErrorService;
    }


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid ContractStatusAddrequest contractStatusAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save Contract Status
        System.out.println(contractStatusAddrequest);
        contractStatusService.saveContractStatus(contractStatusMapper.addRequestToDto(contractStatusAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractStatus, ADDED)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<ContractStatus> getAllContractStatus() {
        return contractStatusService.getAllContractStatus();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all2")
    public List<ContractStatusDto> getAllContractSt() {
        return contractStatusService.getAllContractStatus2();

    }

    @PostMapping("/row/{Id}")
    public ContractStatus getContractStatusById(@PathVariable String Id) {
        return contractStatusService.getById(Id);

    }

    @PostMapping("/delete/{Id}")
    public List<ContractStatusDto> deleteContractStatusById(@PathVariable String Id) {
        System.out.println("test delete :" +Id);
        return contractStatusService.remove(Id);

    }

    @PostMapping("/update")
    public List<ContractStatusDto> update(@RequestBody @Valid ContractStatusUpdaterequest contractStatusUpdaterequest) {
        // Save Contract Status
        String Id = contractStatusUpdaterequest.getContractStatusId();
        System.out.println(contractStatusUpdaterequest + "" + Id);
        contractStatusService.updateContractStatus(contractStatusMapper.updateRequestToDto(contractStatusUpdaterequest), Id);
        return contractStatusService.getAllContractStatus2();
    }

}
