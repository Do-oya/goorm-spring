package spring.springhello.race;

import org.springframework.stereotype.Component;

@Component
public class V6Engine implements Engine {
    @Override
    public void start() {
        System.out.println("V6 Engine starting...");
    }
}
