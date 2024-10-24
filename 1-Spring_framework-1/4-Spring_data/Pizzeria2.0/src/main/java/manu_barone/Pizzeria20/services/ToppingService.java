package manu_barone.Pizzeria20.services;

import lombok.extern.slf4j.Slf4j;
import manu_barone.Pizzeria20.entities.Topping;
import manu_barone.Pizzeria20.repositories.ToppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ToppingService {

    @Autowired
    private ToppingRepo tp;

    public void saveTopping(Topping t){
        tp.save(t);
        log.info("Il topping " + t.getNome() + " è stato salvato correttamente");
    }

    public Topping findByName(String name){
        return tp.findByName(name);
    }
}
