package com.toocol.fspider.core.spide;

import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Receive;

/**
 * @author Joezeo
 * @date 2020/12/12 15:25
 */
public class SpideGroup extends AbstractBehavior<SpideGroup.Command> {

    private final String name = "spide";

    public interface Command{}

    public SpideGroup(ActorContext<Command> context) {
        super(context);
    }

    @Override
    public Receive<Command> createReceive() {
        return null;
    }
}
