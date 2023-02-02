package com.InstituteService.service;

import com.InstituteService.model.Institute;
import java.util.List;

//@Service
public interface InstituteService {

        List<Institute> getAllInstitute();

        Institute getInstituteById(Integer instituteId);

        //GetAllByStudentId
        List<Institute> getInstitutesByStudentId(Integer studentId);

        Institute saveInstitute(Institute institute);

        Institute updateInstitute(Integer instituteId, Institute institute);

        void deleteInstitute(Integer instituteId);

}
