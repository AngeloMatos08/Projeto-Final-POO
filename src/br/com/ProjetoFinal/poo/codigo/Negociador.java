package br.com.ProjetoFinal.poo.codigo;

import javax.swing.JOptionPane;

public class Negociador extends Jogador {

    public Negociador(String nome, int f, int i, int a, int c) {
        super(nome, 10 + (f * 5), "Dinheiro e Cartazes de Procurado", 5, i, c, a);
    }

    @Override
    public void usarHabilidade1() {
        int dado = rolarD6();
        int intelecto = getAtributos();
        int resultado = dado + intelecto + 1; // +1 bônus de lábia
        
        JOptionPane.showMessageDialog(null, 
            "Habilidade: Barracuda (Lábia)\n" +
            "Dado: " + dado + " | Intelecto: +" + intelecto + "\n" +
            "Resultado do convencimento: " + resultado, 
            "Negociação", JOptionPane.QUESTION_MESSAGE);
    }

    @Override
    public void usarHabilidade2() {
        JOptionPane.showMessageDialog(null, 
            "Habilidade: More Than a Feeling\n" +
            "Você pode fazer " + (1 + getAtributos()/2) + " perguntas ao mestre sobre a cena.", 
            "Intuição", JOptionPane.INFORMATION_MESSAGE);
    }
}