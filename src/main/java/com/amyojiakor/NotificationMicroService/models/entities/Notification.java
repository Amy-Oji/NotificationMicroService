package com.amyojiakor.NotificationMicroService.models.entities;

import com.amyojiakor.NotificationMicroService.models.emums.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String recipientEmail;

    private NotificationType type;

    private LocalDateTime timestamp;
}
