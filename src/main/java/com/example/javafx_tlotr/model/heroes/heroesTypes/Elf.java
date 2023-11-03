package com.example.javafx_tlotr.model.heroes.heroesTypes;

import com.example.javafx_tlotr.model.Character;
import com.example.javafx_tlotr.model.beasts.beastsTypes.Orc;
import com.example.javafx_tlotr.model.heroes.Hero;

public class Elf extends Hero {
    public Elf(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public int toAttack(Character enemy) {

        int damage = 0;
        int offensivePower = 10;
        int finalDamage = 0;

        if(enemy instanceof Orc) {

            damage = super.toAttack(enemy);

            System.out.println("¡La potencia ofensiva del ataque se ha visto incrementada debido al odio que sienten los Elfos por los Orcos!");
            finalDamage = damage + offensivePower;
            System.out.println("Ahora el ataque es de: \n" + damage + " + ¡¡ +10 puntos !! = " + finalDamage);

            enemy.toBeAttacked(finalDamage);

        } else {
            damage = super.toAttack(enemy);
            enemy.toBeAttacked(damage);
        }
        return 0;
    }
}
