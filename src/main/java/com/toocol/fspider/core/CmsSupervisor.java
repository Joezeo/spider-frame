package com.toocol.fspider.core;

import akka.actor.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.PostStop;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * Crawler-management-system's core supervisor actor
 *
 * @author Joezeo
 * @date 2020/12/10 21:10
 */
@Slf4j
public class CmsSupervisor extends AbstractBehavior<CmsSupervisor.Message> {

    /**
     * define message protocol interface
     */
    public interface Message {
    }

    public static Behavior<Message> create() {
        return Behaviors.setup(CmsSupervisor::new);
    }

    public CmsSupervisor(ActorContext<Message> context) {
        super(context);
        log.info("start the akka spide system ~");
    }

    /**
     * no need for handle any message
     */
    @Override
    public Receive<Message> createReceive() {
        return newReceiveBuilder()
                .onSignal(PostStop.class, signal -> onPostStop())
                .build();
    }

    private CmsSupervisor onPostStop() {
        log.info("Cms system stoped");
        return this;
    }
}
