package com.toocol.fspider.web;

import akka.actor.typed.ActorRef;
import com.toocol.fspider.core.CmsSupervisor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joezeo
 * @date 2020/12/10 21:27
 */
@RestController
@AllArgsConstructor
public class Controller {

    private final ActorRef<CmsSupervisor.Message> spideSystem;

    @RequestMapping("/init")
    public void init() {

    }

    @RequestMapping("/start")
    public void start() {

    }
}
