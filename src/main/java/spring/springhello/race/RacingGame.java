package spring.springhello.race;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RacingGame {
    private final Car car;
    private final V6Engine v6Engine;
    private final ElectricEngine electricEngine;

    @Autowired
    public RacingGame(Car car, V6Engine v6Engine, ElectricEngine electricEngine) {
        this.car = car;
        this.v6Engine = v6Engine;
        this.electricEngine = electricEngine;
    }

    @GetMapping("/race")
    public String startRace(@RequestParam String engine) {
        switch (engine.toLowerCase()) {
            case "v6":
                car.setEngine(v6Engine);
                break;
            case "electric":
                car.setEngine(electricEngine);
                break;
            default:
                return "Unknown Engine";
        }
        car.startRace();
        return "Race started with " + engine;
    }
}
