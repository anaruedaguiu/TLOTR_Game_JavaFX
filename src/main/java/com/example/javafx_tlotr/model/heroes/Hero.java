package com.example.javafx_tlotr.model.heroes;

import com.example.javafx_tlotr.model.Character;

public class Hero extends Character {
    int dice1;
    int dice2;

    public Hero(String name, int life, int armor) {
        super(name, life, armor);
    }

    @Override
    public int toAttack(Character enemy) {
        System.out.println("➤ " + super.getName() + " está atacando a " + enemy.getName());

        dice1 = (int) (Math.random() * 101);
        System.out.println(" Primer dado: " + dice1);
        dice2 = (int) (Math.random() * 101);
        System.out.println(" Segundo dado: " +dice2);

        int damage = Math.max(dice1, dice2);
        System.out.println(super.getName() + " saca " + damage + " puntos");

        return damage;
    }
}
