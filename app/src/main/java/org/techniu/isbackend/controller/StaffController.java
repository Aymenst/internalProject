package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.StaffAddrequest;
import org.techniu.isbackend.dto.mapper.CommercialOperationStatusMapper;
import org.techniu.isbackend.dto.mapper.StaffMapper;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.service.StaffService;
import org.techniu.isbackend.service.StaffService;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;
import static org.techniu.isbackend.exception.EntityType.Staff;

import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffController {
    private StaffService staffService;
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
    StaffController(StaffService  staffService){
        this.staffService = staffService;
    }

    @RequestMapping(path = "staff-add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff saveStaff(@RequestPart("staff") Staff staff, @RequestPart("city") City city, @RequestPart("staffEconomicContractInformation") StaffEconomicContractInformation staffEconomicContractInformation, @RequestPart("staffContract") StaffContract staffContract,
                           @RequestPart("files[]") List<MultipartFile> staffDocuments, @RequestPart("staffDocumentsList") List<StaffDocuments> staffDocumentsList) throws IOException {
        //System.out.println(staff);
        for (int i = 0; i<staffDocumentsList.size(); i++) {
            staffDocumentsList.get(i).setDocument(staffDocuments.get(i).getBytes());
        }
        return staffService.saveStaff(staff, city, staffEconomicContractInformation, staffContract, staffDocumentsList);
    }

    /**
     * Handles the incoming POST API "/application/add"
     *
     * @param staffAddRequest staffAddRequest
     * @return ApplicationDto
     */
    @PostMapping("staff/add")
    public ResponseEntity add(@ModelAttribute @Valid StaffAddrequest staffAddRequest, BindingResult bindingResult,
                              @RequestParam("idCardPhoto") MultipartFile idCardPhoto,
                              @RequestParam("passportPhoto") MultipartFile passportPhoto,
                              @RequestParam("professionalIdCardDatePhoto") MultipartFile professionalIdCardDatePhoto,
                              @RequestParam("hnsPhoto") MultipartFile hnsPhoto) throws IOException {
       // objet address
        Address address =new Address()
        .setFullAddress(staffAddRequest.getAddressName())
        .setPostCode(staffAddRequest.getPostCode());
        // staffDocumentsList
        List<StaffDocuments> staffDocumentsList =new ArrayList();
        // id card
        StaffDocuments staffDocumentCard= new StaffDocuments();
        staffDocumentCard.setDocument(idCardPhoto.getBytes());
        staffDocumentCard.setDocExtension("null");
        staffDocumentCard.setName(staffAddRequest.getIdCardName());
        staffDocumentCard.setNumber(staffAddRequest.getIdCardNumber());
        staffDocumentsList.add(staffDocumentCard);
        // passport
        StaffDocuments staffDocumentPassport= new StaffDocuments();
        staffDocumentPassport.setDocument(passportPhoto.getBytes());
        staffDocumentPassport.setDocExtension("null");
        staffDocumentPassport.setName(staffAddRequest.getPassportName());
        staffDocumentPassport.setNumber(staffAddRequest.getPassportNumber());
        staffDocumentsList.add(staffDocumentPassport);
        // professional id card
        StaffDocuments staffDocumentProfessional= new StaffDocuments();
        staffDocumentProfessional.setDocument(professionalIdCardDatePhoto.getBytes());
        staffDocumentProfessional.setDocExtension("null");
        staffDocumentProfessional.setName(staffAddRequest.getProfessionalName());
        staffDocumentProfessional.setNumber(staffAddRequest.getProfessionalIdCardNumber());
        staffDocumentsList.add(staffDocumentProfessional);
        // Health National Security
        StaffDocuments staffDocumentHns= new StaffDocuments();
        staffDocumentHns.setDocument(hnsPhoto.getBytes());
        staffDocumentHns.setDocExtension(null);
        staffDocumentHns.setName(staffAddRequest.getHnsName());
        staffDocumentHns.setNumber(staffAddRequest.getHnsNumber());
        staffDocumentsList.add(staffDocumentHns);
        staffService.save(staffMapper.addRequestToDto(staffAddRequest),
                staffAddRequest.getCityId(), address, null, null, staffDocumentsList);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Staff, ADDED)), HttpStatus.OK);
    }
    @RequestMapping(path = "staff-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getStaff(){
        return staffService.getAllStaffs();
    }

    /**
     * display all staff GET API "/api/staff/all"
     */
    @RequestMapping(method = RequestMethod.GET, value = "staff/all")
    public ResponseEntity allStaff() {
        return new ResponseEntity<Response>(Response.ok().setPayload(staffService.getAll()), HttpStatus.OK);
    }

    @RequestMapping(path = "staff-no-assigned",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getNotAssignedStaff(){
        return staffService.getAllNotAssignedStaffs();
    }

    @RequestMapping(path = "assign-level-staff",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void assignLevelToStaff(@RequestBody List<Object> objects){
        staffService.assignLevelToStaff(objects);
    }

    @RequestMapping(path = "get-staff-by-level/levelId={levelId}&isLeader={isLeader}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getStaffsByLevel(@PathVariable("levelId") String levelId, @PathVariable("isLeader") String isLeader){
        return staffService.getStaffsByLevel(levelId, isLeader);
    }
}
