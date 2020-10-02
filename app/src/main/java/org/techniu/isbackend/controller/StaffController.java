package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.validation.BindingResult;
import org.techniu.isbackend.controller.request.StaffAddrequest;
import org.techniu.isbackend.dto.mapper.StaffMapper;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.service.StaffService;
import static org.techniu.isbackend.exception.EntityType.*;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;

import static org.techniu.isbackend.exception.MainException.getMessageTemplate;
import static org.techniu.isbackend.exception.ExceptionType.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffService staffService;
    private final MapValidationErrorService mapValidationErrorService;
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
    public StaffController(StaffService staffService, MapValidationErrorService mapValidationErrorService) {
        this.staffService = staffService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    /**
     * display all staff GET API "/api/staff"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allServices() {
        return new ResponseEntity<Response>(Response.ok().setPayload(staffService.getAllStaffs()), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid StaffAddrequest staffAddRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save staff
        Address address = new Address();
        address.setAddress(staffAddRequest.getAddressName());
        address.setPostCode(staffAddRequest.getPostCode());
        staffService.saveStaff(staffMapper.dtoToModel(staffMapper.addRequestToDto(staffAddRequest)),address,staffAddRequest.getCityId());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Staff, ADDED)), HttpStatus.OK);
    }

    @RequestMapping(path = "all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDto> getStaff(){
        return staffService.getAllStaffs();
    }

    @RequestMapping(path = "staff-no-assigned",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getNotAssignedStaff(){
        return staffService.getAllNotAssignedStaffs();
    }

    @RequestMapping(path = "assign-level-staff",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void assignLevelToStaff(@RequestBody List<Object> objects){
         staffService.assignLevelToStaff(objects);
    }

    @RequestMapping(path = "get-staff-by-level/{levelId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getStaffsByLevel(@PathVariable("levelId") String levelId){
        return staffService.getStaffsByLevel(levelId);
    }



}
