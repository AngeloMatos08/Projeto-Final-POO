package br.com.ProjetoFinal.poo.codigo;

import javax.swing.JOptionPane;

public class Curador extends Jogador {

    public Curador(String nome, int f, int i, int a, int c) {
        super(nome, 10 + (f * 5), "Ervas e Kit Médico", 5, i, c, a);
    }

    @Override
    public void usarHabilidade1() {
        int curaBase = 3;
        int intelecto = getAtributos(); // Intelecto aumenta a cura
        int curaTotal = curaBase + intelecto;
        
        setVida(getVida() + curaTotal); // Aplica a cura ao jogador
        
        JOptionPane.showMessageDialog(null, 
            "Habilidade: Fortunate Son!\n" +
            "Cura Base: " + curaBase + " | Bônus Intelecto: +" + intelecto + "\n" +
            "Você recuperou " + curaTotal + " PV!", 
            "Cura Musical", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void usarHabilidade2() {
        JOptionPane.showMessageDialog(null, 
            "Habilidade: I Want to Hold Your Hand\n" +
            "Bônus passivo em testes de resistência e medicina.", 
            "Habilidade Passiva", JOptionPane.INFORMATION_MESSAGE);
    }
}