package com.yunjae.springtroubleshooting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CustomInfoContributor implements InfoContributor {
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void contribute(Info.Builder builder) {
        HashMap<String, Object> info = new HashMap();
        info.put("bean-definition-count", ctx.getBeanDefinitionCount());
        info.put("startup-date", ctx.getStartupDate());
        builder.withDetail("context", info);
    }
}
