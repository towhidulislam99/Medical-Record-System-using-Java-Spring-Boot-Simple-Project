package com.mrs.doclogin.repository;

import com.mrs.docloginentity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository <Appointment, Long> {
}
