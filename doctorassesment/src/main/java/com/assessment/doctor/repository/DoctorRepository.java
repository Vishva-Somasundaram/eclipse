package com.assessment.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.doctor.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

}
