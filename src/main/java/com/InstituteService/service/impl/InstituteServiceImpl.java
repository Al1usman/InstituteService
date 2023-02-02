package com.InstituteService.service.impl;

import com.InstituteService.model.Institute;
import com.InstituteService.repo.InstituteRepo;
import com.InstituteService.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstituteServiceImpl implements InstituteService {

    @Autowired
    private InstituteRepo instituteRepo;

    //GetAllinstitutes
    @Override
    public List<Institute> getAllInstitute() {
        return instituteRepo.findAll();
    }

    //GetSingleInstitute
    @Override
    public Institute getInstituteById(Integer instituteId) {
        return instituteRepo.findById(instituteId).orElse(null);
    }

    //GetSingleInstitute
    @Override
    public List<Institute> getInstitutesByStudentId(Integer studentId) {
        return instituteRepo.findByStudentId(studentId);
    }

    //CreateInstitutes
    @Override
    public Institute saveInstitute(Institute institute) {
//        String randomInstituteId = UUID.randomUUID().toString();
//        institute.setInstituteId(randomInstituteId);
        return instituteRepo.save(institute);
    }

    //UpdateInstitutes
    @Override
    public Institute updateInstitute(Integer instituteId, Institute institute) {
        Institute existingInstitute = instituteRepo.findById(instituteId).orElse(null);
        if (existingInstitute == null) {
            return null;
        }
        existingInstitute.setStudentId(institute.getStudentId());
        existingInstitute.setInstituteName(institute.getInstituteName());
        existingInstitute.setInstituteAddress(institute.getInstituteAddress());
        existingInstitute.setInstituteContact(institute.getInstituteContact());
        return instituteRepo.save(existingInstitute);
    }

    //DeleteInstitutes
    @Override
    public void deleteInstitute(Integer instituteId) {
        instituteRepo.deleteById(instituteId);
    }

}
