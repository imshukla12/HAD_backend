package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.DoctorDetails;
import com.shield.eaarogya.DTO.LoginCredentials;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ----------------------------------------- Register a Doctor -----------------------------------------
    @PostMapping("/registerDoctor")
    public DoctorDetails registerDoctor(@RequestBody DoctorDetails doctorDetails) {
        return doctorService.addDoctor(doctorDetails);
    }

    //-------------------------------------------Doctor Login-----------------------------------------------
    @PostMapping("/login")
    public DoctorDetails login(@RequestBody LoginCredentials loginCredentials) {
        String email = loginCredentials.getEmail();
        String password = loginCredentials.getPassword();
        DoctorDetails doctorDetails = doctorService.login(email, password);
        return doctorDetails;
    }

    // ------------------------------------- Get List of all Doctors ------------------------------------------
    @GetMapping("/getAllDoctors")
    public List<DoctorDetails> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // ------------------------------------- Get Doctor Details by Email ------------------------------------------
    @GetMapping("/getdoctorByEmail/{email}")
    public DoctorDetails getDoctorByEmail(@PathVariable String email) {
//        String email = loginCredentials.getEmail();

        return doctorService.findByEmail(email);
    }

    // ------------------------------------- Phone number Verification ----------------------------------

}
