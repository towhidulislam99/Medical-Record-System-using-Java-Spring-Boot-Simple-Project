package com.mrs.repository;

import com.mrs.entity.Patient;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
