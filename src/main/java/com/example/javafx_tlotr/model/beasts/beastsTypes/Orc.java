package com.example.javafx_tlotr.model.beasts.beastsTypes;

import com.example.javafx_tlotr.model.Character;
import com.example.javafx_tlotr.model.beasts.Beast;

public class Orc extends Beast {
    public Orc(String name, int life, int armor) {

        super(name, life, armor);

    }

    @Override
    public int toAttack(Character enemy) {

        double weakening = 0.10;

        int damage = super.toAttack(enemy);

        System.out.println("¡La potencia ofensiva del ataque debilita un 10% la armadura de " + enemy.getName() + " debido a la fuerza desmesurada de " + this.getName() + "!");
        int originalArmor = enemy.getArmor();
        int weakenedArmor = (int) Math.ceil(originalArmor - (originalArmor * weakening));
        enemy.setArmor(weakenedArmor);

        enemy.toBeAttacked(damage);

        enemy.setArmor(originalArmor);

        return 0;
    }
}
