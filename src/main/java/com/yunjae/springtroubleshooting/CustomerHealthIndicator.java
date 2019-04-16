package com.yunjae.springtroubleshooting;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
public class CustomerHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        LocalDate today = LocalDate.now();
        if (today.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            return Health.outOfService().withDetail("outOfServiceOn", today.getDayOfWeek()).build();
        }
        return Health.up().build();
    }
}
