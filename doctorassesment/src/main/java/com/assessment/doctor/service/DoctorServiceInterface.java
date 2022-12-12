package com.assessment.doctor.service;

import java.util.List;
import java.util.Optional;

import com.assessment.doctor.entity.Doctor;

public interface DoctorServiceInterface {
	boolean addperson(Doctor save);
	Optional<Doctor> findById(int id);
	Doctor update(Doctor updateDoctor);
    int deleteById(int id);
    List<Doctor> show();
}
