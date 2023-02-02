package com.InstituteService.repo;

import com.InstituteService.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituteRepo extends JpaRepository<Institute, Integer> {

    // Custom Finder Methods
    List<Institute> findByStudentId(Integer studentId);

}
