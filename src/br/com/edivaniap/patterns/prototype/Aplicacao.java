package br.com.edivaniap.patterns.prototype;

import br.com.edivaniap.patterns.prototype.model.General;
import br.com.edivaniap.patterns.prototype.model.Guerreiro;

public class Aplicacao {

    public static void main(String[] args) {
        Guerreiro guerreiro1 = new Guerreiro();
        guerreiro1.mover("x", 10);
        guerreiro1.mover("y", 25);
        guerreiro1.atacar();
        guerreiro1.atacar();

        System.out.println(guerreiro1);

        try {
            Guerreiro guerreiro2 = (Guerreiro) guerreiro1.clone();
            System.out.println(guerreiro2 + (" (clonado)"));
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        General general1 = new General();
        general1.mover("x", 38);
        general1.mover("y", 90);
        general1.comandar();
        general1.comandar();
        general1.comandar();

        System.out.println(general1);

        try {
            General general2 = (General) general1.clone();
            System.out.println(general2 + (" (clonado)"));
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

}
