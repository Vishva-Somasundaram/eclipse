package com.assessment.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.doctor.entity.Doctor;
import com.assessment.doctor.repository.DoctorRepository;

@Service
public class DoctorService implements DoctorServiceInterface{
	
	@Autowired
	private DoctorRepository repo;
	@Override
	public boolean addperson(Doctor save) {
		// here
		String patternStr = "\\d{10}";
		int di = save.getId();
		String dn = save.getName();
		String dp = String.valueOf( save.getPhNo());
		String ds = save.getSpl();
		if(di != 0 && dn != "" && Pattern.compile(patternStr).matcher(dp).matches() && ds != "") {
			repo.save(save);
			System.out.println();
			return true;	
		}
		return false;
	}

	@Override
	public Optional<Doctor> findById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public Doctor update(Doctor updateDoctor) {
		
		return repo.save(updateDoctor);
	}

	@Override
	public int deleteById(int id) {
		
		repo.deleteById(id);
		return 0;
	}

	@Override
	public List<Doctor> show() {
		List<Doctor> doctorList = new ArrayList<Doctor>();
        doctorList = repo.findAll();
        return doctorList;
	}
	
}
