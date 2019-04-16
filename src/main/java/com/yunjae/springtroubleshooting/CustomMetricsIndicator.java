package com.yunjae.springtroubleshooting;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
class WebEndPoint {
    private final CustomMetricsIndicator customMetrics;

    public WebEndPoint(CustomMetricsIndicator metrics) {
        this.customMetrics = metrics;
    }

    @GetMapping("/callCustomMetrics")
    @ResponseBody
    public String dothecall() {
        this.customMetrics.counted();
        return "Done";
    }
}

@Service
public class CustomMetricsIndicator {
    private final Counter counter;

    public CustomMetricsIndicator(MeterRegistry registry) {
        this.counter = Counter.builder("customMetricsCounter")
        .description("a custom metrics")
        .register(registry);
    }

    public void counted() {
        this.counter.increment();
    }
}
