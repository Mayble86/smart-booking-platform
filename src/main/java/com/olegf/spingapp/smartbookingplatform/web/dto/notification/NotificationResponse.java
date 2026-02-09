package com.olegf.spingapp.smartbookingplatform.web.dto.notification;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NotificationResponse {
    private Long id;
    private String recipientEmail;
    private String title;
    private String content;
    private String type;
    private String status;
    private LocalDateTime createdAt;
}
