package com.toocol.fspider.web;

import akka.actor.typed.ActorRef;
import com.toocol.fspider.core.SpideSystem;
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

    private final ActorRef<SpideSystem.Message> spideSystem;

    @RequestMapping("/start")
    public void test() {
        spideSystem.tell(new SpideSystem.SpideMsg());
    }
}
