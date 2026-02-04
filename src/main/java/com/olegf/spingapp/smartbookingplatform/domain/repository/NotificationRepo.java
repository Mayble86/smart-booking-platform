package com.olegf.spingapp.smartbookingplatform.domain.repository;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
