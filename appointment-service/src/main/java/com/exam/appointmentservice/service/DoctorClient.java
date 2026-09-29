package com.exam.appointmentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DoctorClient {

    private final RestTemplate restTemplate;

    public boolean exists(Long doctorId) {
        try {
            restTemplate.getForObject(
                    "http://DOCTOR-SERVICE/api/v1/doctors/" + doctorId,
                    Object.class
            );

            return true;

        } catch (Exception e) {
            return false;
        }
    }
}