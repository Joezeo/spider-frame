package com.toocol.fspider.config;

import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import com.toocol.fspider.core.CmsSupervisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Crawler Management System akka config : registe the system supervisior into spring
 * @author Joezeo
 * @date 2020/12/10 21:13
 */
@Configuration
public class CrawlerManagementSystemConfig {

    @Bean("spideSystem")
    public ActorRef<CmsSupervisor.Message> initSpideSystem() {
        return ActorSystem.create(CmsSupervisor.create(), "crawler-management-system");
    }

}
