package br.com.edivaniap.patterns.prototype.model;

public class Guerreiro extends ElementoJogo {

    private Integer poder = 500;

    public void atacar() {
        super.estado = "atacando";
        this.poder -= 20;
    }

    @Override
    public String toString() {
        return "Guerreiro " + getEstado() + " em (" + getX() + ", " + getY() + ") | Poder: " + this.poder;
    }

    @Override
    protected void resetar() {
        this.poder = 500; // Reseta poder ao clonar
    }

}
