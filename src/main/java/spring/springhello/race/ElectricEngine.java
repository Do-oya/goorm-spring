package spring.springhello.race;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Electric Engine starting...");
    }
}
