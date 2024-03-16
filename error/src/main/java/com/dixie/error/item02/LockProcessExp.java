package com.dixie.error.item02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dixiey
 * @version 1.0
 * @description: TODO
 * @date 2024/3/16 12:43
 */
@RestController
@Slf4j
@RequestMapping("LockProcessExp")
public class LockProcessExp {
    @Slf4j
    public static class Interesting {
        volatile int a = 1;
        volatile int b = 1;
        public synchronized void add() {
            log.info("add start");
            for (int i = 0; i < 10000; i++) {
                a++;
                b++;
            }
            log.info("add done");
        }
        public synchronized void compare() {
            log.info("compare start");
            for (int i = 0; i < 10000; i++) {
                //a始终等于b吗？
                if (a < b) {
                    log.info("a:{},b:{},{}", a, b, a > b);
                    //最后的a>b应该始终是false吗？
                }
            }
            log.info("compare done");
        }
    }

    @GetMapping("wrong")
    public String wrong()  {
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
        return "OK";
    }


}
