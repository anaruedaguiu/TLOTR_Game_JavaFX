package com.example.javafx_tlotr.model.beasts;

import com.example.javafx_tlotr.model.Character;

public class Beast extends Character {
    int damage;

    public Beast(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public int toAttack(Character enemy) {
        System.out.println("➤ " + super.getName() + " está atacando a " + enemy.getName());

        damage = (int) (Math.random() * 91);
        System.out.println(" Primer dado: " + damage);
        System.out.println(super.getName() + " saca " + damage + " puntos");

        return damage;
    }
}
