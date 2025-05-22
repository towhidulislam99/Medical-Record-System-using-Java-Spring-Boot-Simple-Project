package com.mrs.doclogin.controller;


import com.mrs.doclogin.repository.MedicineRepository;
import com.mrs.docloginentity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineController(MedicineRepository medicineRepository) {
        super();
        this.medicineRepository = medicineRepository;
    }

    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicine(){
        return medicineRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicine(@PathVariable Long id){
        if(!medicineRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Medicine Not Found with Id: " +id);
        }
        medicineRepository.deleteById(id);
        return ResponseEntity.ok("Medicine Delete Successfully with Id: " +id);
    }

}
