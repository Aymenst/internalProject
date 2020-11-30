package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.StaffDocumentAddrequest;
import org.techniu.isbackend.dto.mapper.StaffDocumentMapper;
import org.techniu.isbackend.dto.mapper.StaffMapper;
import org.techniu.isbackend.dto.model.StaffDocumentDto;
import org.techniu.isbackend.entity.StaffDocument;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.StaffDocumentService;

import java.io.IOException;

import static org.techniu.isbackend.exception.EntityType.StaffDocuments;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/staffDocument")
@CrossOrigin("*")
public class StaffDocumentController {
    private StaffDocumentService staffDocumentService;
    private final MapValidationErrorService mapValidationErrorService;

    private final StaffDocumentMapper staffDocumentMapper = Mappers.getMapper(StaffDocumentMapper.class);

    StaffDocumentController(StaffDocumentService staffDocumentService, MapValidationErrorService mapValidationErrorService){
        this.staffDocumentService = staffDocumentService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("save")
    public ResponseEntity add(@ModelAttribute("staffDocuments") StaffDocumentAddrequest staffDocumentAddrequest, @RequestParam("doc") MultipartFile doc,
                                             BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        StaffDocumentDto staffDocumentDto = staffDocumentMapper.addRequestToDto(staffDocumentAddrequest);
        staffDocumentDto.setDocument(doc.getBytes());
        staffDocumentService.save(staffDocumentDto, staffDocumentAddrequest.getStaffId());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(StaffDocuments, ADDED)), HttpStatus.OK);
    }

    
    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String staffDocumentId){
        staffDocumentService.remove(staffDocumentId);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(StaffDocuments, DELETED)), HttpStatus.OK);
    }


}
