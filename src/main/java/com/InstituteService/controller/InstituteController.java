package com.InstituteService.controller;

import com.InstituteService.model.Institute;
import com.InstituteService.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institutes")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @GetMapping("/")
    public ResponseEntity<List<Institute>> getAllInstitute(){
        List<Institute> getAllInstitutes = instituteService.getAllInstitute();
        return ResponseEntity.ok(getAllInstitutes);
    }

    //GetSingleInstitute Details
    @GetMapping("/getInstituteById/{instituteId}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable Integer instituteId) {
        Institute institute = instituteService.getInstituteById(instituteId);
        if (institute == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(institute);
    }


    //GetInstitutesByStudentId
    @GetMapping("/{studentId}")
    public ResponseEntity<List<Institute>> getInstitutesByStudentId(@PathVariable Integer studentId){
        return ResponseEntity.ok(instituteService.getInstitutesByStudentId(studentId));
    }

    //CreateStudents
    @PostMapping("/createInstitute")
    public ResponseEntity<Institute> createInstitute(@RequestBody Institute institute){
        Institute institute1 = instituteService.saveInstitute(institute);
        return ResponseEntity.status(HttpStatus.CREATED).body(institute1);
    }

    //UpdateInstitute
    @PutMapping("/{instituteId}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable Integer instituteId, @RequestBody Institute institute){
        Institute updatedInstitute = instituteService.updateInstitute(instituteId, institute);
        return ResponseEntity.ok(updatedInstitute);
    }

    //DeleteInstitute
    @DeleteMapping("/{instituteId}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable Integer instituteId){
        instituteService.deleteInstitute(instituteId);
        return ResponseEntity.noContent().build();
    }


}
