package com.demo.notification.controller;

import com.demo.notification.dto.NotificationRequest;
import com.demo.notification.dto.NotificationResponse;
import com.demo.notification.service.NotificationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void receive(@Valid @RequestBody NotificationRequest request) {
        notificationService.recordRestNotification(request);
    }

    @GetMapping("/{travelRequestId}")
    public List<NotificationResponse> findByTravelRequestId(@PathVariable @Positive Long travelRequestId) {
        return notificationService.findByTravelRequestId(travelRequestId);
    }
}
