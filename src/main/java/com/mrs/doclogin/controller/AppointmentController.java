package com.mrs.doclogin.controller;


import com.mrs.doclogin.repository.AppointmentsRepository;
import com.mrs.docloginentity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment){
        Optional<Appointment> optionalAppointment = appointmentsRepository.findById(id);

        if(optionalAppointment.isPresent()){
            Appointment appointment = optionalAppointment.get();
            appointment.setName(updatedAppointment.getName());
            appointment.setAge(updatedAppointment.getAge());
            appointment.setSymptoms(updatedAppointment.getSymptoms());
            appointment.setNumber(updatedAppointment.getNumber());

            Appointment savedAppointment = appointmentsRepository.save(appointment);
            return ResponseEntity.ok(savedAppointment);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Appointment> patchAppoinment(@PathVariable Long id, @RequestBody Map<String, Object> updates){

        Optional<Appointment> optionalAppointment = appointmentsRepository.findById(id);

        if(optionalAppointment.isPresent()){

            Appointment appointment = optionalAppointment.get();

            if(updates.containsKey("name")){
                appointment.setName((String) updates.get("name"));
            }

            if(updates.containsKey("age")){
                appointment.setAge((String) updates.get("age"));
            }

            if(updates.containsKey("symptoms")){
                appointment.setSymptoms((String) updates.get("symptoms"));
            }

            if(updates.containsKey("number")){
                appointment.setNumber((String) updates.get("number"));
            }

            Appointment savedAppointment = appointmentsRepository.save(appointment);
            return ResponseEntity.ok(savedAppointment);

        }

        else {
            return ResponseEntity.notFound().build();
        }

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
