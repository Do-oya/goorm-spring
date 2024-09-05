package spring.springhello.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private Engine engine;

    @Autowired
    public Car(@Qualifier("v6Engine") Engine engine) {
        this.engine = engine;
    }


    public void startRace() {
        engine.start();
    }

    public void setEngine(V6Engine v6Engine) {
        this.engine = v6Engine;
    }

    public void setEngine(ElectricEngine electricEngine) {
        this.engine = electricEngine;
    }
}

