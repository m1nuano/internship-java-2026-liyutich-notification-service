package com.demo.notification.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record NotificationRequest(
        @NotNull @Positive Long travelRequestId,
        String oldStatus,
        String newStatus
) {
}
