package com.mrs.doclogin.controller;


import com.mrs.doclogin.repository.MedicineRepository;
import com.mrs.docloginentity.Medicine;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine upatedMedicine){
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);

        if(optionalMedicine.isPresent()){
            Medicine medicine = optionalMedicine.get();
            medicine.setDrugName(upatedMedicine.getDrugName());
            medicine.setStock(upatedMedicine.getStock());

            Medicine savedMedicine =medicineRepository.save(medicine);
            return ResponseEntity.ok(savedMedicine);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Medicine> patchMedicine(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);

        if(optionalMedicine.isPresent()){
            Medicine medicine = optionalMedicine.get();

            if(updates.containsKey("drugName")){
                medicine.setDrugName((String) updates.get("drugName"));
            }

            if(updates.containsKey("stock")){
                medicine.setStock((String) updates.get("stock"));
            }

            Medicine savedMedicine = medicineRepository.save(medicine);
            return ResponseEntity.ok(savedMedicine);
        }

        else {
            return ResponseEntity.notFound().build();
        }
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
