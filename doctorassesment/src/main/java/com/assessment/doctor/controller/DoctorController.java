package com.assessment.doctor.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.doctor.entity.Doctor;
import com.assessment.doctor.service.DoctorServiceInterface;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoctorController {
	@Autowired
	private DoctorServiceInterface service;
	
	@RequestMapping(value="/addDoctor",method= RequestMethod.POST)
    public String addDoctor(@RequestBody Doctor obj) {
    	if (service.addperson(obj)) {
            return "Added successfully on Id : "+obj.getId();
    	} else {
    		return "failed !!!";
    	}
    }
	
	@RequestMapping(value="/findDoctor",method= RequestMethod.GET)
    public Doctor  homepagep(Doctor id) {
          Optional<Doctor> find = service.findById(id.getId());
          Doctor d = find.get();
        return d;
    }
	
	@RequestMapping(value="/updateDoctor",method= RequestMethod.PUT)
    public int modifyPerson(@RequestBody Doctor id) {
    	service.update(id);
        return 0;
    }
    
    @RequestMapping(value="/removeDoctor",method= RequestMethod.DELETE)
    public long removePerson(@RequestBody Doctor id) {
    	@SuppressWarnings("unused")
		Optional<Doctor> find = service.findById(id.getId());
    	service.deleteById(id.getId());
        return 0;
    }
    @RequestMapping(value="/getDoc",method= RequestMethod.GET)
	public List<Doctor> getdoc(){
		return service.show();
    }
}

