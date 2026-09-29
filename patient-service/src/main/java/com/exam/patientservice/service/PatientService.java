package com.exam.patientservice.service;

import com.exam.patientservice.dto.request.PatientRequest;
import com.exam.patientservice.enitity.Patient;
import com.exam.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient createPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setFullName(patientRequest.fullName());
        patient.setGender(patientRequest.gender());
        patient.setAddress(patientRequest.address());
        patient.setPhoneNumber(patientRequest.phoneNumber());
        patient.setDateOfBirth(patientRequest.dateOfBirth());
        patient.setMedicalHistory(patientRequest.medicalHistory());

        return patientRepository.save(patient);
    }

    public Patient getById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
