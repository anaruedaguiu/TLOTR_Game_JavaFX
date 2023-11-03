package com.example.javafx_tlotr.model.heroes.heroesTypes;

import com.example.javafx_tlotr.model.beasts.beastsTypes.Goblin;
import com.example.javafx_tlotr.model.Character;
import com.example.javafx_tlotr.model.heroes.Hero;

public class Hobbit extends Hero {
    public Hobbit(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public int toAttack(Character enemy) {

        int damage = 0;
        int offensivePower = 5;
        int finalDamage = 0;

        if(enemy instanceof Goblin) {

            damage = super.toAttack(enemy);

            System.out.println("¡La potencia ofensiva del ataque se ha visto perjudicada debido al miedo que sienten los Hobbits por los Trasgos!");
            finalDamage = damage - offensivePower;
            System.out.println("Ahora el ataque es de: \n" + damage + " + ¡¡ -5 puntos !! = " + finalDamage);

            enemy.toBeAttacked(finalDamage);

        } else {
            damage = super.toAttack(enemy);
            enemy.toBeAttacked(damage);
        }

        return 0;
    }
}
