package br.com.ProjetoFinal.poo.codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        // CONFIGS JANELA
        setTitle("RPG-O Som Das Seis");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // FUNDO
        JPanel painelMelhorado = new JPanel();
        painelMelhorado.setLayout(new BoxLayout(painelMelhorado, BoxLayout.Y_AXIS));
        painelMelhorado.setBackground(new Color(30, 30, 30));

        // TITULO DA PAGINA
        JLabel lblTitulo = new JLabel("SOM DAS SEIS");
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 32));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BOTAO CRIAÇÃO
        JButton btnIniciar = new JButton("CRIAR FORASTEIRO");
        btnIniciar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnIniciar.addActionListener(e -> {
            new TelaCriacao(); // VAI PARA CRIACAO
            this.dispose();    // FECHA MENU
        });
        
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 18));
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.setMaximumSize(new Dimension(250, 50));


        // ORGANIZAÇÃO VISUAL
        painelMelhorado.add(Box.createRigidArea(new Dimension(0, 80))); // TOPO
        painelMelhorado.add(lblTitulo);
        painelMelhorado.add(Box.createRigidArea(new Dimension(0, 50))); // TITULO-BOTAO
        painelMelhorado.add(btnIniciar);

        getContentPane().add(painelMelhorado);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Garante que o Swing rode na thread correta
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal();
        });
    }
}