package com.toocol.fspider.core;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;
import com.toocol.fspider.resolver.AbstractPageResolver;
import lombok.AllArgsConstructor;

/**
 * spide management system core
 *
 * @author Joezeo
 * @date 2020/12/10 21:10
 */
public class SpideSystem extends AbstractBehavior<SpideSystem.Message> {
    /* ---protocol start--- */
    /**
     * define message protocol interface
     */
    public interface Message {
    }

    /**
     * when spide system recive this msg, make sub actor to spide url
     */
    public static final class SpideMsg implements Message {
    }

    /**
     * when spide system recive this msg, make sub actor to resolve page
     */
    public static final class ResolveMsg implements Message {
    }

    /**
     * when spide system recive this msg, make a sub core to store the data to mongo
     */
    public static final class StoreMsg implements Message {
    }
    /* ---protocol end--- */

    public static Behavior<Message> create() {
        return Behaviors.setup(SpideSystem::new);
    }

    public SpideSystem(ActorContext<Message> context) {
        super(context);
        getContext().getLog().info("start the akka spide system ~");
    }

    @Override
    public Receive<Message> createReceive() {
        return newReceiveBuilder()
                .onMessage(SpideMsg.class, this::onSpide)
                .onMessage(ResolveMsg.class, this::onResolve)
                .onMessage(StoreMsg.class, this::onStore)
                .build();
    }

    private Behavior<Message> onSpide(Message message) {
        return this;
    }

    private Behavior<Message> onResolve(Message message) {
        return this;
    }

    private Behavior<Message> onStore(Message message) {
        return this;
    }
}
