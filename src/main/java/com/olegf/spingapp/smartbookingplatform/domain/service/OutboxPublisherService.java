package com.olegf.spingapp.smartbookingplatform.domain.service;

import com.olegf.spingapp.smartbookingplatform.domain.entity.OutboxEvent;
import com.olegf.spingapp.smartbookingplatform.domain.repository.OutboxEventRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OutboxPublisherService {
    private final OutboxEventRepo outboxRepo;

    public void publishPendingEvents() {
        List<OutboxEvent> pending = outboxRepo.findByProcessedFalseOrderByCreatedAtAsc();

        for (OutboxEvent event : pending) {
            try {
                log.info("Fake Kafka {}", event.getEventType());
                event.setProcessed(true);
            } catch (Exception e) {
                log.error("Failed: {}", event.getId());
            }
        }

        if (!pending.isEmpty()) {
            outboxRepo.saveAll(pending);
        }
    }
}
