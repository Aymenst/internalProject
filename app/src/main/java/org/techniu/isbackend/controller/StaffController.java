package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.StaffAddrequest;
import org.techniu.isbackend.controller.request.StaffUpdaterequest;
import org.techniu.isbackend.dto.mapper.StaffMapper;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.*;
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
@RequestMapping("/api/staff")
@CrossOrigin("*")
public class StaffController {
    private StaffService staffService;
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
    StaffController(StaffService  staffService){
        this.staffService = staffService;
    }

    /**
     * Handles the incoming POST API "/application/add"
     *
     * @param staffAddRequest staffAddRequest
     * @return ApplicationDto
     */
    @PostMapping("/add")
    public ResponseEntity add(@ModelAttribute @Valid StaffAddrequest staffAddRequest, BindingResult bindingResult,
                              @RequestParam("idCardDoc") MultipartFile idCardDoc,
                              @RequestParam("passportDoc") MultipartFile passportDoc,
                              @RequestParam("professionalIdCardDoc") MultipartFile professionalIdCardDoc,
                              @RequestParam("hnsCardDoc") MultipartFile hnsCardDoc,
                              @RequestParam("contractDoc") MultipartFile contractDoc,
                              @RequestParam("internalRulesDoc") MultipartFile internalRulesDoc,
                              @RequestParam("preContractDoc") MultipartFile preContractDoc) throws IOException {
       // objet address
        Address address =new Address()
        .setFullAddress(staffAddRequest.getFullAddress())
        .setPostCode(staffAddRequest.getPostCode());
        // staffDocumentsList
        List<StaffDocuments> staffDocumentsList =new ArrayList();
        // id card
        if(!idCardDoc.getContentType().equals("application/json")) {
            StaffDocuments staffDocumentCard= new StaffDocuments();
            staffDocumentCard.setDocument(idCardDoc.getBytes());
            staffDocumentCard.setDocExtension(staffAddRequest.getIdCardDocExtension());
            staffDocumentCard.setName(staffAddRequest.getIdCardName());
            staffDocumentCard.setNumber(staffAddRequest.getIdCardNumber());
            staffDocumentsList.add(staffDocumentCard);
        };
        // passport
        if(!passportDoc.getContentType().equals("application/json")){
            StaffDocuments staffDocumentPassport= new StaffDocuments();
            staffDocumentPassport.setDocument(passportDoc.getBytes());
            staffDocumentPassport.setDocExtension(staffAddRequest.getPassportDocExtension());
            staffDocumentPassport.setName(staffAddRequest.getPassportName());
            staffDocumentPassport.setNumber(staffAddRequest.getPassportNumber());
            staffDocumentsList.add(staffDocumentPassport);
        }
        // professional id
        if(!professionalIdCardDoc.getContentType().equals("application/json")){
            StaffDocuments staffDocumentProfessional= new StaffDocuments();
            staffDocumentProfessional.setDocument(professionalIdCardDoc.getBytes());
            staffDocumentProfessional.setDocExtension(staffAddRequest.getProfessionalIdCardDocExtension());
            staffDocumentProfessional.setName(staffAddRequest.getProfessionalName());
            staffDocumentProfessional.setNumber(staffAddRequest.getProfessionalIdCardNumber());
            staffDocumentsList.add(staffDocumentProfessional);
        }
        // Health National Security
        if(!hnsCardDoc.getContentType().equals("application/json")){
            StaffDocuments staffDocumentHns= new StaffDocuments();
            staffDocumentHns.setDocument(hnsCardDoc.getBytes());
            staffDocumentHns.setDocExtension(staffAddRequest.getHnsDocExtension());
            staffDocumentHns.setName(staffAddRequest.getHnsName());
            staffDocumentHns.setNumber(staffAddRequest.getHnsNumber());
            staffDocumentsList.add(staffDocumentHns);
        }

        // Staff contract
        StaffContract staffContract = new StaffContract();
        staffContract.setAssociateOffice(staffAddRequest.getAssociateOffice());
        staffContract.setHiringCountry(staffAddRequest.getHiringCountry());
        staffContract.setTownContract(staffAddRequest.getTownContract());
        staffContract.setPersonalNumber(staffAddRequest.getPersonalNumber());
        staffContract.setHighDate(staffAddRequest.getHighDate());
        staffContract.setLowDate(staffAddRequest.getLowDate());
        staffContract.setRegistrationDate(staffAddRequest.getRegistrationDate());
        staffContract.setPreContractDate(staffAddRequest.getPreContractDate());
        if(contractDoc.getContentType().equals("application/pdf")){
            staffContract.setContractDoc(contractDoc.getBytes());
        }
        if(internalRulesDoc.getContentType().equals("application/pdf")){
            staffContract.setInternalRulesDoc(internalRulesDoc.getBytes());
        }
        if(preContractDoc.getContentType().equals("application/pdf")){
            staffContract.setPreContractDoc(preContractDoc.getBytes());
        }

        // Staff economic contract
        StaffEconomicContractInformation staffEconomicContractInformation = new StaffEconomicContractInformation();
        staffEconomicContractInformation.setContractSalary(staffAddRequest.getContractSalary());
        staffEconomicContractInformation.setCompanyContractCost(staffAddRequest.getCompanyContractCost());
        staffEconomicContractInformation.setExpenses(staffAddRequest.getExpenses());
        staffEconomicContractInformation.setCompanyExpensesCost(staffAddRequest.getCompanyExpensesCost());
        staffEconomicContractInformation.setObjectives(staffAddRequest.getObjectives());
        staffEconomicContractInformation.setCompanyObjectivesCost(staffAddRequest.getCompanyObjectivesCost());
        staffEconomicContractInformation.setTotalCompanyCost(staffAddRequest.getTotalCompanyCost());
        staffEconomicContractInformation.setContractSalaryDateGoing(staffAddRequest.getContractSalaryDateGoing());
        staffEconomicContractInformation.setContractSalaryDateOut(staffAddRequest.getContractSalaryDateOut());
        staffEconomicContractInformation.setCompanyContractCostDateGoing(staffAddRequest.getCompanyContractCostDateGoing());
        staffEconomicContractInformation.setCompanyContractCostDateOut(staffAddRequest.getCompanyContractCostDateOut());
        staffEconomicContractInformation.setExpensesDateGoing(staffAddRequest.getExpensesDateGoing());
        staffEconomicContractInformation.setExpensesDateOut(staffAddRequest.getExpensesDateOut());
        staffEconomicContractInformation.setCompanyExpensesCostDateGoing(staffAddRequest.getCompanyExpensesCostDateGoing());
        staffEconomicContractInformation.setCompanyExpensesCostDateOut(staffAddRequest.getCompanyExpensesCostDateOut());
        staffEconomicContractInformation.setObjectivesDateGoing(staffAddRequest.getObjectivesDateGoing());
        staffEconomicContractInformation.setObjectivesDateOut(staffAddRequest.getObjectivesDateOut());
        staffEconomicContractInformation.setCompanyObjectivesCostDateGoing(staffAddRequest.getCompanyObjectivesCostDateGoing());
        staffEconomicContractInformation.setCompanyObjectivesCostDateOut(staffAddRequest.getCompanyObjectivesCostDateOut());
        staffEconomicContractInformation.setTotalCompanyCostDateGoing(staffAddRequest.getTotalCompanyCostDateGoing());
        staffEconomicContractInformation.setTotalCompanyCostDateOut(staffAddRequest.getTotalCompanyCostDateOut());
        System.out.println(staffAddRequest.getCompanyId());
        staffService.save(staffMapper.addRequestToDto(staffAddRequest),
                staffAddRequest.getCityId(), address, staffEconomicContractInformation, staffContract, staffAddRequest.getCompanyId(), staffAddRequest.getContractTypeId(), staffAddRequest.getLegalCategoryTypeId(), staffDocumentsList);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Staff, ADDED)), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid StaffUpdaterequest staffUpdaterequest, BindingResult bindingResult) {
        Address address =new Address()
                .setAddressId(staffUpdaterequest.getAddressId())
                .setFullAddress(staffUpdaterequest.getFullAddress())
                .setPostCode(staffUpdaterequest.getPostCode());
        staffService.update(staffMapper.updateRequestToDto(staffUpdaterequest),
                staffUpdaterequest.getCityId(), address);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Staff, UPDATED)), HttpStatus.OK);
    }

    @RequestMapping(path = "staff-by-id/{staffId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffDto getStaffById(@PathVariable("staffId") String staffId){
        return staffService.getStaffById(staffId);
    }

    /**
     * display all staff GET API "/api/staff/all"
     * @return
     */
    @GetMapping("/all")
    public List<StaffDto> allStaff() {
        return staffService.getAll();
    }

    /**
     * display all staff GET API "/api/staff/allaid"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/allaid")
    public ResponseEntity allstaffaid() {
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
