package com.mrs.doclogin.controller;


import com.mrs.doclogin.repository.AppointmentsRepository;
import com.mrs.docloginentity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentsRepository appointmentsRepository;

    @Autowired
    public AppointmentController(AppointmentsRepository appointmentsRepository) {
        super();
        this.appointmentsRepository = appointmentsRepository;
    }

    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentsRepository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentsRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id){
        if(!appointmentsRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appointments Not Found With This Id: " +id);
        }
        appointmentsRepository.deleteById(id);
        return ResponseEntity.ok("Medicine Delete Successfully with Id: " +id);
    }

}
