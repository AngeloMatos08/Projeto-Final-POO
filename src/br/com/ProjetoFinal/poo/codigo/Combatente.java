package br.com.ProjetoFinal.poo.codigo;

import javax.swing.JOptionPane;

public class Combatente extends Jogador {
    
    public Combatente(String nome, int f, int i, int a, int c) {
        // Vida = 10 + (f*5) | Equipamento: Revólver e Munição | Defesa: 5 | Atributos(I), Iniciativa(C), Ações(A)
        super(nome, 10 + (f * 5), "Revólver e Munições", 5, i, c, a);
    }

    @Override
    public void usarHabilidade1() {
        int dado = rolarD6();
        int intelecto = getAtributos(); // Soma o Intelecto ao teste
        int resultado = dado + intelecto + 1; // +1 bônus da habilidade
        
        JOptionPane.showMessageDialog(null, 
            "Habilidade: Light My Fire!\n" +
            "Dado: " + dado + " | Intelecto: +" + intelecto + " | Bônus: +1\n" +
            "Resultado do Ataque: " + resultado, 
            "Combate", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void usarHabilidade2() {
        JOptionPane.showMessageDialog(null, 
            getNome() + " usou Lets Dance!\nRealiza dois disparos rápidos gastando 1 ação.", 
            "Habilidade Especial", JOptionPane.WARNING_MESSAGE);
    }
}