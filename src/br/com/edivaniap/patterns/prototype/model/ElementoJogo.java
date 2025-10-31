package br.com.edivaniap.patterns.prototype.model;

/**
 * Representa um elemento de jogo que é exibido em um mapa.
 * Classe abstrata do prototype, que define o metodo clone.
 */

public abstract class ElementoJogo implements Cloneable {

    private Integer x;
    private Integer y;
    protected String estado;

    public ElementoJogo() {
        this.x = 0;
        this.y = 0;
        this.estado = "parado";
    }

    private ElementoJogo(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.estado = "parado";
    }

    @Override
    public ElementoJogo clone() throws CloneNotSupportedException {
        // Clonagem rasa (shallow copy) via Object.clone()
        ElementoJogo clone = (ElementoJogo) super.clone();
        // Reinicializa o estado para valores padrão
        clone.inicializar();
        return clone;
    }

    protected void inicializar() {
        this.x = 0;
        this.y = 0;
        this.estado = "parado";
        resetar(); // Delega para subclasses
    }

    // Cada subclasse reseta seus próprios atributos
    protected abstract void resetar();

    public void mover(String direcao, Integer distancia) {
        switch (direcao) {
            case "x":
                this.x += distancia;
                break;
            case "y":
                this.y += distancia;
                break;
            default:
                throw new IllegalArgumentException("Direção inválida");
        }
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public String getEstado() {
        return this.estado;
    }

}
