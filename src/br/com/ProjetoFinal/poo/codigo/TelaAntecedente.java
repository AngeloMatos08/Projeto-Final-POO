package br.com.ProjetoFinal.poo.codigo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import br.com.ProjetoFinal.poo.codigo.*;

public class TelaAntecedente extends JFrame {
    // Dados herdados das telas anteriores
    private String nome;
    private int fisico, intelecto, agilidade, coragem;

    // Componentes da Interface
    private JSpinner[] spinners = new JSpinner[8];
    private JTextArea areaDescricao;
    private JLabel lblPontos;
    private JButton btnProximo;
    
    private final String[] nomesAntecedentes = {
        "Combate", "Negócios", "Montaria", "Tradição", 
        "Labuta", "Exploração", "Medicina", "Roubo"
    };

    public TelaAntecedente(String nome, int f, int i, int a, int c) {
        this.nome = nome;
        this.fisico = f;
        this.intelecto = i;
        this.agilidade = a;
        this.coragem = c;

        configurarJanela();
        setLayout(new BorderLayout(10, 10));

        // 1. Painel de Seleção (Esquerda)
        JPanel painelSelecao = new JPanel(new GridLayout(8, 1, 5, 5));
        painelSelecao.setBorder(BorderFactory.createTitledBorder("Distribua 4 Pontos"));

        for (int x = 0; x < 8; x++) {
            painelSelecao.add(criarLinhaAntecedente(x));
        }
        add(painelSelecao, BorderLayout.CENTER);

        // 2. Painel de Descrição (Direita)
        areaDescricao = new JTextArea("Passe o mouse sobre os nomes para ler as descrições.");
        areaDescricao.setLineWrap(true);
        areaDescricao.setWrapStyleWord(true);
        areaDescricao.setEditable(false);
        areaDescricao.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane scrollDesc = new JScrollPane(areaDescricao);
        scrollDesc.setPreferredSize(new Dimension(300, 0));
        scrollDesc.setBorder(BorderFactory.createTitledBorder("Detalhes do Antecedente"));
        add(scrollDesc, BorderLayout.EAST);

        // 3. Painel Inferior (Status e Botão)
        JPanel painelSul = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblPontos = new JLabel("PONTOS RESTANTES: 4  ");
        lblPontos.setFont(new Font("Arial", Font.BOLD, 14));
        
        btnProximo = new JButton("CONFIGURAR CAVALO >>");
        btnProximo.setEnabled(false);
        
        // CORREÇÃO: Adicionando a ação ao botão
        btnProximo.addActionListener(e -> avancarParaCavalo());

        painelSul.add(lblPontos);
        painelSul.add(btnProximo);
        add(painelSul, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel criarLinhaAntecedente(int index) {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String nomeAt = nomesAntecedentes[index];
        
        JLabel lblNome = new JLabel(nomeAt);
        lblNome.setPreferredSize(new Dimension(100, 20));
        lblNome.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblNome.setForeground(new Color(150, 0, 0)); 
        
        lblNome.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                areaDescricao.setText(getTextoDescricao(nomeAt));
                areaDescricao.setCaretPosition(0); 
            }
        });

        // Regra: Máximo de 2 pontos por antecedente
        spinners[index] = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));
        spinners[index].addChangeListener(e -> atualizarPontos());

        painel.add(lblNome);
        painel.add(spinners[index]);
        return painel;
    }

    private void atualizarPontos() {
        int total = 0;
        for (JSpinner s : spinners) total += (int) s.getValue();
        
        int sobra = 4 - total;
        lblPontos.setText("PONTOS RESTANTES: " + sobra + "  ");
        
        if (sobra < 0) {
            lblPontos.setForeground(Color.RED);
            btnProximo.setEnabled(false);
        } else {
            lblPontos.setForeground(Color.BLACK);
            // Botão habilita apenas com exatamente 4 pontos gastos
            btnProximo.setEnabled(sobra == 0); 
        }
    }

    private void configurarJanela() {
        setTitle("Antecedentes - " + nome);
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // CORREÇÃO: Método de transição funcional
    private void avancarParaCavalo() {
        // Passa os dados acumulados para a próxima tela
        new TelaCavalo(nome, fisico, intelecto, agilidade, coragem);
        this.dispose(); // Fecha a tela atual
    }

    private String getTextoDescricao(String ant) {
        switch (ant) {
            case "Combate": return "Seja uma veterana da Guerra Civil ou um errante solitário, você vive pela violência. Importante para atirar, lutar corpo a corpo e estratégias.";
            case "Negócios": return "Negociatas de saloon e acordos comerciais. Use para seduzir, fascinar, descobrir mentiras e convencer pessoas com língua afiada.";
            case "Montaria": return "Domínio sobre cavalos e animais de carga. Dá bônus para manobras, torna a montaria mais veloz e ajuda a rastrear gado.";
            case "Tradição": return "Preservação de origem e cultura. Conhecimento sobre fauna, flora, venenos naturais e comunicação com outras culturas.";
            case "Labuta": return "Trabalho pesado e resistência. Conhecimento para construir/consertar e aptidões físicas como nadar, correr e saltar.";
            case "Exploração": return "Sobrevivência nos territórios mais hostis. Perceber ameaças, rastrear inimigos e sobreviver em selvas ou desertos.";
            case "Medicina": return "Conhecimento acadêmico sobre anatomia e cura. Especialista em cirurgias e remoção de balas. Ajuda na recuperação de Vida no descanso.";
            case "Roubo": return "Estilo de vida furtivo e ligeiro. Dedos ágeis para trapaças, bater carteiras e fugir de encrencas sorrateiramente.";
            default: return "";
        }
    }
}