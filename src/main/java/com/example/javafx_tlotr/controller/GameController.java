package com.example.javafx_tlotr.controller;

import com.example.javafx_tlotr.model.beasts.Beast;
import com.example.javafx_tlotr.model.Character;
import com.example.javafx_tlotr.model.heroes.Hero;

import java.util.List;

public class GameController {
    private List<Hero> heroesArmy;
    private List<Beast> beastsArmy;
    private int turn;
    private String winner;

    public GameController(List<Hero> ejercitoHeroes, List<Beast> ejercitoBestias) {
        this.heroesArmy = ejercitoHeroes;
        this.beastsArmy = ejercitoBestias;
        this.turn = 1;
        this.winner = null;
    }

    public String getWinner() {
        return winner;
    }

    public void play() {
        do {
            System.out.println("   ♦♦♦♦♦ TURNO " + turn + " ♦♦♦♦♦");
            System.out.println("··· Estado de los Ejércitos en el turno: " + turn + " ···");
            System.out.println("◇ Ejército de Héroes:");
            printArmy(heroesArmy);
            System.out.println("◇ Ejército de Bestias:");
            printArmy(beastsArmy);
            System.out.println("···············································");

            fight();

            if (heroesArmy.isEmpty()) {
                winner = "Bestias";
            } else if (beastsArmy.isEmpty()) {
                winner = "Héroes";
            }

            turn++;

        } while (!heroesArmy.isEmpty() && !beastsArmy.isEmpty());

        System.out.println("     ¡¡VICTORIA DE " + winner.toUpperCase() + "!!");
    }

    private void fight() {
        for (int i = 0; i < Math.min(heroesArmy.size(), beastsArmy.size()); i++) {
            Hero hero = heroesArmy.get(i);
            Beast beast = beastsArmy.get(i);
            System.out.println(" ▷▷ Lucha entre " + hero.getName().toUpperCase()
                    + " (Vida=" + hero.getLife()
                    + " Armadura=" + hero.getArmor()
                    + ") y " + beast.getName().toUpperCase()
                    + " (Vida=" + beast.getLife()
                    + " Armadura=" + beast.getArmor() + ") ◁◁");

            hero.toAttack(beast);
            if (beast.isDead()) {
                System.out.println("¡" + beast.getName() + " ha sido derrotado!");
            } else {
                beast.toAttack(hero);
                if (hero.isDead()) {
                    System.out.println("¡" + hero.getName() + " ha sido derrotado!");
                }
            }

            System.out.println("\n" + "········· Estado de los personajes tras el ataque:");
            System.out.println("Vida de " + hero.getName() + " tras el ataque: " + hero.getLife());
            System.out.println("Vida de " + beast.getName() + " tras el ataque: " + beast.getLife() + "\n");
        }

        heroesArmy.removeIf(heroe -> heroe.isDead());
        beastsArmy.removeIf(bestia -> bestia.isDead());

        System.out.println("········· Estado de los ejércitos tras el ataque:");
        System.out.println("Ejército de Héroes: " + heroesArmy.size() + " guerreros vivos");
        System.out.println("Ejército de Bestias: " + beastsArmy.size() + " guerreros vivos \n");
        System.out.println("------------------------------------------------" + "\n");
    }

    private void printArmy(List<? extends Character> ejercito) {
        for (Character personaje : ejercito) {
            System.out.println(" " + personaje.getName()
                    + " (Vida = " + personaje.getLife()
                    + " Armadura = " + personaje.getArmor() + ")");
        }
    }

}
