package br.com.ProjetoFinal.poo.codigo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import br.com.ProjetoFinal.poo.codigo.*;

public class TelaCriacao extends JFrame {
    private JTextField txtNome;
    private JSpinner spinFisico, spinIntelecto, spinAgilidade, spinCoragem;
    private JLabel lblPontosRestantes;
    private JButton btnAvancar;
    private int pontosDisponiveis = 4;

    public TelaCriacao() {
        setTitle("Criação de Personagem - Atributos");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(0, 2, 10, 10));

        // NOME PERSONAGEM
        add(new JLabel(" Nome do(a) Forasteiro:"));
        txtNome = new JTextField();
        add(txtNome);

        // PONTOS SOBRANDO
        lblPontosRestantes = new JLabel("PONTOS RESTANTES: 4");
        lblPontosRestantes.setForeground(Color.RED);
        lblPontosRestantes.setFont(new Font("Arial", Font.BOLD, 14));
        add(new JLabel("DISTRIBUIÇÃO DE ATRIBUTOS:"));
        add(lblPontosRestantes);

        // ATRIBUTOS
        spinFisico = criarSpinnerAtributo();
        add(new JLabel(" Físico (+5 Vida p/ ponto):"));
        add(spinFisico);

        spinIntelecto = criarSpinnerAtributo();
        add(new JLabel(" Intelecto (+1 Antecedente):"));
        add(spinIntelecto);

        spinAgilidade = criarSpinnerAtributo();
        add(new JLabel(" Agilidade (+1 Ação):"));
        add(spinAgilidade);

        spinCoragem = criarSpinnerAtributo();
        add(new JLabel(" Coragem (+1 Iniciativa):"));
        add(spinCoragem);

        // BOTAO PARA PROXIMA JANELA
        btnAvancar = new JButton("ESCOLHER ANTECEDENTE >>");
        btnAvancar.addActionListener(e -> abrirEscolhaClasse());
        add(new JLabel(""));
        add(btnAvancar);

        setVisible(true);
    }

    private JSpinner criarSpinnerAtributo() {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 4, 1));
        
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                validarPontos();
            }
        });
        return spinner;
    }

    private void validarPontos() {
        int totalGasto = (int) spinFisico.getValue() + 
                         (int) spinIntelecto.getValue() + 
                         (int) spinAgilidade.getValue() + 
                         (int) spinCoragem.getValue();
        
        int sobra = pontosDisponiveis - totalGasto;

        if (sobra < 0) {
            lblPontosRestantes.setText("LIMITE EXCEDIDO!");
            btnAvancar.setEnabled(false);
        } else {
            lblPontosRestantes.setText("PONTOS RESTANTES: " + sobra);
            btnAvancar.setEnabled(sobra == 0); 
        }
    }

    private void abrirEscolhaClasse() {
        if (txtNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dê um nome ao seu personagem primeiro");
            return;
        }

        // ARMAZENA OS ATRIBUTOS
        String nome = txtNome.getText();
        int f = (int) spinFisico.getValue();
        int i = (int) spinIntelecto.getValue();
        int a = (int) spinAgilidade.getValue();
        int c = (int) spinCoragem.getValue();

        // TELA PARA ESCOLHA DE ANTECEDENTES
        new TelaAntecedente(nome, f, i, a, c); 
        
        this.dispose(); 
    }
    }
