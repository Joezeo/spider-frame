package com.toocol.fspider.config;

import akka.actor.typed.ActorRef;
import akka.actor.typed.ActorSystem;
import com.toocol.fspider.core.SpideSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Joezeo
 * @date 2020/12/10 21:13
 */
@Configuration
public class AkkaConfig {

    @Bean("spideSystem")
    public ActorRef<SpideSystem.Message> initSpideSystem() {
        return ActorSystem.create(SpideSystem.create(), "spide-system");
    }

}
