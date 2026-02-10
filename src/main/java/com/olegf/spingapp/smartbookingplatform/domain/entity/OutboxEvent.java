package com.olegf.spingapp.smartbookingplatform.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "outbox_events")
public class OutboxEvent {
    @Id
    @GeneratedValue
    private Long id;

    private String eventType;

    @Column(columnDefinition = "TEXT")
    private String payload;

    private boolean processed = false;

    private LocalDateTime createdAt = LocalDateTime.now();
}
