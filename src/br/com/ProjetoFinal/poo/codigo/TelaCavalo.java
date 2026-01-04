package br.com.ProjetoFinal.poo.codigo;

import javax.swing.*;
import java.awt.*;
import br.com.ProjetoFinal.poo.codigo.*;

public class TelaCavalo extends JFrame {
    private String nomeJogador;
    private int f, i, a, c;

    private JSpinner spinPotencia, spinResistencia;
    private JLabel lblStatusPontos;
    private JButton btnFinalizar;

    public TelaCavalo(String nome, int fisico, int intelecto, int agilidade, int coragem) {
        this.nomeJogador = nome;
        this.f = fisico;
        this.i = intelecto;
        this.a = agilidade;
        this.c = coragem;

        configurarJanela();
        setLayout(new BorderLayout(15, 15));

        // Painel de Regras
        JTextArea areaRegras = new JTextArea(
            "Distribua TRÊS PONTOS entre Potência e Resistência.\n\n" +
            "POTÊNCIA: Velocidade e agilidade (1d6 + Potência + Montaria).\n" +
            "RESISTÊNCIA: Cada ponto soma 1d6+6 à vida da montaria."
        );
        areaRegras.setEditable(false);
        areaRegras.setBackground(new Color(245, 245, 220));
        add(new JScrollPane(areaRegras), BorderLayout.NORTH);

        // Painel de Seleção
        JPanel painelCentral = new JPanel(new GridLayout(2, 2, 10, 10));
        spinPotencia = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));
        spinResistencia = new JSpinner(new SpinnerNumberModel(0, 0, 3, 1));

        spinPotencia.addChangeListener(e -> validarPontosCavalo());
        spinResistencia.addChangeListener(e -> validarPontosCavalo());

        painelCentral.add(new JLabel("POTÊNCIA (Velocidade):"));
        painelCentral.add(spinPotencia);
        painelCentral.add(new JLabel("RESISTÊNCIA (Vida/Vigor):"));
        painelCentral.add(spinResistencia);
        add(painelCentral, BorderLayout.CENTER);

        // Painel Inferior
        JPanel painelSul = new JPanel();
        lblStatusPontos = new JLabel("PONTOS RESTANTES: 3");
        btnFinalizar = new JButton("ESCOLHER CLASSE FINAL >>");
        btnFinalizar.setEnabled(false);
        btnFinalizar.addActionListener(e -> irParaEscolhaClasse());

        painelSul.add(lblStatusPontos);
        painelSul.add(btnFinalizar);
        add(painelSul, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void validarPontosCavalo() {
        int p = (int) spinPotencia.getValue();
        int r = (int) spinResistencia.getValue();
        int sobra = 3 - (p + r);

        if (sobra < 0) {
            lblStatusPontos.setText("LIMITE EXCEDIDO!");
            lblStatusPontos.setForeground(Color.RED);
            btnFinalizar.setEnabled(false);
        } else {
            lblStatusPontos.setText("PONTOS RESTANTES: " + sobra);
            lblStatusPontos.setForeground(Color.BLACK);
            btnFinalizar.setEnabled(sobra == 0); // Exatamente 3 pontos
        }
    }

    private void configurarJanela() {
        setTitle("Ficha da Montaria - " + nomeJogador);
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void irParaEscolhaClasse() {
        int pot = (int) spinPotencia.getValue();
        int res = (int) spinResistencia.getValue();
        
        // Transição para a última tela de escolha de classe
        new TelaEscolhaClasse(nomeJogador, f, i, a, c, pot, res);
        this.dispose();
    }
}