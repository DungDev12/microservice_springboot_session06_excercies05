package com.exam.doctorservice.service;

import com.exam.doctorservice.dto.response.DoctorResponse;
import com.exam.doctorservice.entity.Doctor;
import com.exam.doctorservice.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<DoctorResponse> getDoctors(){
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> new DoctorResponse(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSpecialization()
                )).toList();
    }

    public Doctor getById(Long id){
        return doctorRepository.findById(id).orElse(null);
    }
}
