package com.demo.notification.service;

import com.demo.notification.document.Notification;
import com.demo.notification.dto.NotificationRequest;
import com.demo.notification.dto.NotificationResponse;
import com.demo.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void recordRestNotification(NotificationRequest request) {
        Notification notification = new Notification(null, request.travelRequestId(), request.oldStatus(),
                request.newStatus(), Instant.now(), "REST");
        notificationRepository.insert(notification);
    }

    public List<NotificationResponse> findByTravelRequestId(Long travelRequestId) {
        return notificationRepository.findByTravelRequestIdOrderByNotificationSentAtDescIdDesc(travelRequestId)
                .stream()
                .map(notification -> new NotificationResponse(notification.travelRequestId(), notification.oldStatus(),
                        notification.newStatus(), notification.notificationSentAt(), notification.channel()))
                .toList();
    }
}
