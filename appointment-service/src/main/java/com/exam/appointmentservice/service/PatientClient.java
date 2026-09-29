package com.exam.appointmentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PatientClient {

    private final RestTemplate restTemplate;

    public boolean exists(Long patientId) {
        try {
            restTemplate.getForObject(
                    "http://PATIENT-SERVICE/api/v1/patients/" + patientId,
                    Object.class
            );

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
