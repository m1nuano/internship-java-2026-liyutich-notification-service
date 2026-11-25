package com.demo.notification.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;

@Document(collection = "notifications")
public record Notification(
        @Id String id,
        Long travelRequestId,
        @Field(write = Field.Write.ALWAYS) String oldStatus,
        @Field(write = Field.Write.ALWAYS) String newStatus,
        Instant notificationSentAt,
        String channel
) {
}
