package com.demo.notification.dto;

import java.time.Instant;

public record NotificationResponse(
        Long travelRequestId,
        String oldStatus,
        String newStatus,
        Instant notificationSentAt,
        String channel
) {
}
