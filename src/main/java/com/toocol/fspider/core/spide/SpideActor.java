package com.toocol.fspider.core.spide;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Joezeo
 * @date 2020/12/10 22:01
 */
@Slf4j
public class SpideActor extends AbstractBehavior<SpideActor.Command> {
    /**
     * define message protocol interface
     */
    public interface Command {}
    @AllArgsConstructor
    public static final class StartSpideCmd implements Command {
        private final String url;
    }

    private final String url;

    public static Behavior<Command> create(String url) {
        return Behaviors.setup(context -> new SpideActor(context, url));
    }

    public SpideActor(ActorContext<Command> context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    public Receive<Command> createReceive() {
        return newReceiveBuilder()
                .onMessage(StartSpideCmd.class, this::onStart)
                .build();
    }

    private Behavior<Command> onStart(Command command) {
        log.info("url -> {}", url);
        return this;
    }

}
