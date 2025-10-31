package br.com.edivaniap.patterns.prototype.model;

//Não permite clone...
public class General extends ElementoJogo {

    private Integer respeito = 0;

    public void comandar() {
        super.estado = "comandando";
        this.respeito += 5;
    }

    @Override
    public String toString() {
        return "General " + getEstado() + " em (" + getX() + ", " + getY() + ") | Respeito: " + this.respeito;
    }

    @Override
    public ElementoJogo clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Generais são únicos.");
    }

    @Override
    protected void resetar() {
        this.respeito = 0;
    }

}