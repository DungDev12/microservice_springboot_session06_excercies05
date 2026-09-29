package com.exam.appointmentservice.controller;

import com.exam.appointmentservice.dto.request.AppointmentRequest;
import com.exam.appointmentservice.dto.response.AppointmentResponse;
import com.exam.appointmentservice.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponse create(
            @RequestBody AppointmentRequest request
    ) {
        return appointmentService.create(request);
    }
}