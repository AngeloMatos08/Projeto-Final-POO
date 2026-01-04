package br.com.ProjetoFinal.poo.codigo;

import javax.swing.JOptionPane;
import java.util.Random;

public abstract class Jogador extends Entidade {
    private int atributos, iniciativa, acoes;

    public Jogador(String nome, int vida, String equipamentos, int defesa, int atributos, int iniciativa, int acoes) {
        super(nome, vida, equipamentos, defesa); 
        this.atributos = atributos;
        this.iniciativa = iniciativa;
        this.acoes = acoes;
    }

    public abstract void usarHabilidade1();
    public abstract void usarHabilidade2();

    // Lógica de Turno Visual com JOptionPane
    @Override
    public void executarTurno() {
        int acoesTurno = this.acoes;
        String[] opcoes = {"Habilidade 1", "Habilidade 2", "Descansar"};

        while (acoesTurno > 0) {
            int escolha = JOptionPane.showOptionDialog(null, 
                "Turno de: " + getNome() + "\nAções restantes: " + acoesTurno,
                "Menu de Combate",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, 
                null, opcoes, opcoes[0]);

            if (escolha == 0) {
                usarHabilidade1();
                acoesTurno--;
            } else if (escolha == 1) {
                usarHabilidade2();
                acoesTurno--;
            } else if (escolha == 2 || escolha == -1) {
                realizarDescanso();
                acoesTurno = 0; // Finaliza o turno ao descansar
            }
        }
        JOptionPane.showMessageDialog(null, "Fim do turno de " + getNome());
    }

    public void realizarDescanso() {
        JOptionPane.showMessageDialog(null, getNome() + " utilizou o turno para descansar e recuperar o foco.");
    }

    public int rolarD6() {
        return new Random().nextInt(6) + 1;
    }

    public int getAcoes() { return acoes; }
    public int getIniciativa() { return iniciativa; }
    public int getAtributos() { return atributos; }
}