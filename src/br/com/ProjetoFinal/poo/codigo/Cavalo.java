package br.com.ProjetoFinal.poo.codigo;
import java.util.Random;

public class Cavalo extends Entidade {
    private int potencia, vigor;

    public Cavalo(String nome, int pot, int res) {
        super(nome, 10, "Sela de Couro", 5);
        this.potencia = pot;
        this.vigor = res;
        
        Random rand = new Random();
        for(int j = 0; j < res; j++) {
            // Cada ponto soma 1d6 + 6 à vida
            setVida(getVida() + (rand.nextInt(6) + 1) + 6);
        }
    }

    @Override
    public void executarTurno() {
        System.out.println("O cavalo aguarda ordens.");
    }

    public int getPotencia() { return potencia; }
    public int getVigor() { return vigor; }
}