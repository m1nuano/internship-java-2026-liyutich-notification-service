package com.demo.notification.repository;

import com.demo.notification.document.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    List<Notification> findByTravelRequestIdOrderByNotificationSentAtDescIdDesc(Long travelRequestId);
}
