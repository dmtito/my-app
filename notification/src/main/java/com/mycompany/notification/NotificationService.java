package com.mycompany.notification;

import com.mycompany.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        log.info("Saving notification to {}", notificationRequest.toCustomerEmail());
        notificationRepository.save(Notification.builder()
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .toCustomerId(notificationRequest.toCustomerId())
                .message(notificationRequest.message())
                .sentAt(LocalDateTime.now())
                .sender("tito")
                .build());
    }
}
