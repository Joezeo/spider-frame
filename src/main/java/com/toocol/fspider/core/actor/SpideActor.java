package com.toocol.fspider.core.actor;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joezeo
 * @date 2020/12/10 22:01
 */
@Slf4j
public class SpideActor extends AbstractBehavior<SpideActor.Message> {
    /**
     * define message protocol interface
     */
    public interface Message{}
    public static final class StartSpideMsg implements Message {
    }

    private final String url;

    public static Behavior<Message> create(String url) {
        return Behaviors.setup(context -> new SpideActor(context, url));
    }

    public SpideActor(ActorContext<Message> context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public Receive<Message> createReceive() {
        return newReceiveBuilder()
                .onMessage(StartSpideMsg.class, this::onStart)
                .build();
    }

    private Behavior<Message> onStart(Message message) {
        log.info("url -> {}", url);
        return this;
    }

}
