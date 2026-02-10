package com.olegf.spingapp.smartbookingplatform.domain.service;

import com.olegf.spingapp.smartbookingplatform.domain.entity.Booking;
import com.olegf.spingapp.smartbookingplatform.domain.entity.Notification;
import com.olegf.spingapp.smartbookingplatform.domain.repository.NotificationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepo notificationRepo;

    @Async
    public void senBookingNotification(Booking booking) {
        Notification notif = new Notification();

        notif.setRecipientEmail(
                booking
                        .getClient()
                        .getEmail()
        );

        notif.setTitle("Booking Confirmed!");
        notif.setContent("Your booking #: " + booking.getId() + " confirmed");

        notificationRepo.save(notif);
    }
}
