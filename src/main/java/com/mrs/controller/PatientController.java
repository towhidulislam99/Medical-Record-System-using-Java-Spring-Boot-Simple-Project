package com.mrs.controller;

import com.mrs.docloginentity.Medicine;
import com.mrs.entity.Patient;
import com.mrs.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository) {
        super();
        this.patientRepository = patientRepository;
    }

    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient){

        return patientRepository.save(patient);
    }

    @GetMapping
    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient updatedPatient){
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if(optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            patient.setName(updatedPatient.getName());
            patient.setAge(updatedPatient.getAge());
            patient.setBlood(updatedPatient.getBlood());
            patient.setDose(updatedPatient.getDose());
            patient.setPrescription(updatedPatient.getPrescription());
            patient.setFees(updatedPatient.getFees());
            patient.setUrgency(updatedPatient.getUrgency());

            Patient savedPatient = patientRepository.save(patient);
            return ResponseEntity.ok(savedPatient);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Patient> patchPatient (@PathVariable Long id, @RequestBody Map<String, Object> updates){
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        if(optionalPatient.isPresent()){
          Patient patient = optionalPatient.get();

          if(updates.containsKey("name")){
              patient.setName((String) updates.get("name") );
          }

          if(updates.containsKey("age")){
              patient.setAge((String) updates.get("age"));
          }

          if(updates.containsKey("blood")){
              patient.setBlood((String) updates.get("blood"));
          }

          if(updates.containsKey("prescription")){
              patient.setPrescription((String) updates.get("prescription"));
          }

          if(updates.containsKey("dose")){
              patient.setDose((String) updates.get("dose"));
          }

          if(updates.containsKey("fees")){
              patient.setFees((String) updates.get("fees"));
          }

          if(updates.containsKey("urgency")){
              patient.setUrgency((String) updates.get("urgency"));
          }

          patientRepository.save(patient);
          return ResponseEntity.ok(patient);

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        if(!patientRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient Not Found With This Id: " +id);
        }
        patientRepository.deleteById(id);
        return ResponseEntity.ok("Medicine Delete Successfully with Id: " +id);
    }


}




