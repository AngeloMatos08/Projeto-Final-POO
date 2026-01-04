package br.com.ProjetoFinal.poo.codigo;

import javax.swing.*;
import java.awt.*;
import br.com.ProjetoFinal.poo.codigo.*;

public class TelaEscolhaClasse extends JFrame {
    private String nome;
    private int fisico, intelecto, agilidade, coragem;
    private int potCavalo, resCavalo;

    public TelaEscolhaClasse(String nome, int f, int i, int a, int c, int pot, int res) {
        this.nome = nome;
        this.fisico = f;
        this.intelecto = i;
        this.agilidade = a;
        this.coragem = c;
        this.potCavalo = pot;
        this.resCavalo = res;

        setTitle("Escolha sua Classe");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 3, 10, 10));

        add(criarBotaoClasse("COMBATENTE", "Habilidades:\n- Light My Fire\n- Lets Dance", Color.RED));
        add(criarBotaoClasse("NEGOCIADOR", "Habilidades:\n- Barracuda\n- More Than a Feeling", Color.BLUE));
        add(criarBotaoClasse("CURADOR", "Habilidades:\n- Fortunate Son\n- I Want to Hold Your Hand", Color.GREEN));

        setVisible(true);
    }

    private JButton criarBotaoClasse(String titulo, String habilidades, Color cor) {
        JButton btn = new JButton("<html><center><b>" + titulo + "</b><br><br>" + habilidades.replace("\n", "<br>") + "</center></html>");
        btn.setBackground(cor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.addActionListener(e -> finalizarCriacao(titulo));
        return btn;
    }

    private void finalizarCriacao(String classeEscolhida) {
        Jogador personagemFinal;

        // Instanciação usando os construtores de 5 parâmetros que ajustamos
        switch (classeEscolhida) {
            case "COMBATENTE":
                personagemFinal = new Combatente(nome, fisico, intelecto, agilidade, coragem); 
                break;
            case "NEGOCIADOR":
                personagemFinal = new Negociador(nome, fisico, intelecto, agilidade, coragem);
                break;
            default: // CURADOR
                personagemFinal = new Curador(nome, fisico, intelecto, agilidade, coragem);
                break;
        }

        // Criação do objeto Cavalo com a lógica de vida 1d6+6 por ponto
        Cavalo meuCavalo = new Cavalo("Pé de Pano", potCavalo, resCavalo);

        // CORREÇÃO: Em vez de apenas o pop-up, abrimos a ficha e passamos os objetos
        new TelaFichaFinal(personagemFinal, meuCavalo);
        
        // Agora fechamos apenas esta tela de escolha
        this.dispose();
    }
}