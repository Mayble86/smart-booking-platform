package com.olegf.spingapp.smartbookingplatform;

import org.springframework.boot.SpringApplication;

public class TestSmartBookingPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.from(SmartBookingPlatformApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
