package br.com.ProjetoFinal.poo.codigo;

import javax.swing.*;
import java.awt.*;
import br.com.ProjetoFinal.poo.codigo.*;

public class TelaFichaFinal extends JFrame {

    public TelaFichaFinal(Jogador jogador, Cavalo cavalo) {
        // Configurações básicas da janela
        setTitle("Ficha Finalizada");
        setSize(450, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        // Área de Texto com o Resumo dos Cálculos
        JTextArea areaResumo = new JTextArea();
        areaResumo.setEditable(false);
        areaResumo.setFont(new Font("Monospaced", Font.BOLD, 14));
        areaResumo.setBackground(new Color(255, 253, 231)); // Cor estilo papel antigo
        
        // Montando o texto com os dados processados
        String textoFicha = 
            "======= STATUS DO JOGADOR =======\n" +
            "Nome: " + jogador.getNome() + "\n" +
            "Classe: " + jogador.getClass().getSimpleName() + "\n" +
            "Vida: " + jogador.getVida() + " PV\n" +
            "Defesa: " + jogador.getDefesa() + "\n" +
            "Iniciativa (Coragem): " + jogador.getIniciativa() + "\n" +
            "Ações (Agilidade): " + jogador.getAcoes() + "\n" +
            "Intelecto: " + jogador.getAtributos() + "\n" +
            "Equipamento: " + jogador.getEquipamentos() + "\n\n" +
            "======= STATUS DA MONTARIA =======\n" +
            "Nome: " + cavalo.getNome() + "\n" +
            "Vida do Cavalo: " + cavalo.getVida() + " PV\n" +
            "Potência: " + cavalo.getPotencia() + "\n" +
            "Vigor (Resistência): " + cavalo.getVigor() + "\n" +
            "==================================";

        areaResumo.setText(textoFicha);
        add(new JScrollPane(areaResumo), BorderLayout.CENTER);

        // Botão para Iniciar o Turno (Interface Gráfica)
        JButton btnTurno = new JButton("INICIAR TURNO DE COMBATE");
        btnTurno.setFont(new Font("Arial", Font.BOLD, 16));
        btnTurno.setBackground(new Color(34, 139, 34));
        btnTurno.setForeground(Color.WHITE);
        
        // Quando clicado, executa a lógica de turno do personagem
        btnTurno.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Iniciando turno de " + jogador.getNome() + "!");
            jogador.executarTurno(); 
        });

        add(btnTurno, BorderLayout.SOUTH);

        setVisible(true);
    }
}