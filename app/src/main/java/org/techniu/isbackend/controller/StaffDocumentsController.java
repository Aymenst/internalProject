package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.techniu.isbackend.entity.StaffDocuments;
import org.techniu.isbackend.entity.StaffDocuments;
import org.techniu.isbackend.service.StaffDocumentsService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffDocumentsController {
    private StaffDocumentsService staffDocumentsService;
    StaffDocumentsController(StaffDocumentsService staffDocumentsService){
        this.staffDocumentsService = staffDocumentsService;
    }

    @RequestMapping(path = "staffDocuments-save/{staffId}",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffDocuments saveStaffDocuments(@RequestPart("staffDocuments") StaffDocuments staffDocuments, @RequestPart("doc") MultipartFile doc,
                                             @PathVariable("staffId") String staffId) throws IOException {
        staffDocuments.setDocument(doc.getBytes());
        return staffDocumentsService.addStaffDocument(staffDocuments, staffId);
    }

    
    @RequestMapping(path = "staffDocuments-delete/{staffDocumentsId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStaffDocuments(@PathVariable("staffDocumentsId") String staffDocumentsId){
        staffDocumentsService.deleteStaffDocuments(staffDocumentsId);
    }


}
