package io.github.lvbo.ltml;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lvbo
 * @version V1.0
 * @date 2020/5/9 07:40
 */
@Component
public class MemLeaker {
    private List<Object> objs = new LinkedList<>();
    @Scheduled(fixedRate = 1000)
    public void run() {
        for (int i = 0; i < 50000; i++) {
            objs.add(new Object());
        }
    }
}