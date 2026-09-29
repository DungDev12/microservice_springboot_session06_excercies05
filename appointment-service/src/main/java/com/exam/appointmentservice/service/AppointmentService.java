package com.exam.appointmentservice.service;

import com.exam.appointmentservice.dto.request.AppointmentRequest;
import com.exam.appointmentservice.dto.response.AppointmentResponse;
import com.exam.appointmentservice.entity.Appointment;
import com.exam.appointmentservice.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientClient patientClient;
    private final DoctorClient doctorClient;

    public AppointmentResponse create(AppointmentRequest request) {

        // Kiểm tra Patient
        if (!patientClient.exists(request.patientId())) {
            throw new RuntimeException(
                    "Patient not found: " + request.patientId()
            );
        }

        // Kiểm tra Doctor
        if (!doctorClient.exists(request.doctorId())) {
            throw new RuntimeException(
                    "Doctor not found: " + request.doctorId()
            );
        }

        Appointment appointment = new Appointment();

        appointment.setPatientId(request.patientId());
        appointment.setDoctorId(request.doctorId());
        appointment.setAppointmentDate(request.appointmentDate());
        appointment.setReason(request.reason());
        appointment.setStatus("PENDING");

        Appointment saved = appointmentRepository.save(appointment);

        return new AppointmentResponse(
                saved.getId(),
                saved.getPatientId(),
                saved.getDoctorId(),
                saved.getAppointmentDate(),
                saved.getReason(),
                saved.getStatus()
        );
    }
}
