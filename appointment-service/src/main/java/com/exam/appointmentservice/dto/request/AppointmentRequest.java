package com.exam.appointmentservice.dto.request;

import java.time.LocalDateTime;

public record AppointmentRequest(
        Long patientId,
        Long doctorId,
        LocalDateTime appointmentDate,
        String reason
) {
}
