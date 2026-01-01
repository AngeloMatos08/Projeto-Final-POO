package br.com.ProjetoFinal.poo.codigo;

import java.util.Scanner;

public class Negociador extends Jogador{	
    //===== CONSTRUTORES =====
    public Negociador(String nome, int vida, String equipamentos, int defesa,
            int atributos, int iniciativa, int acoes) {

super(nome, vida, equipamentos, defesa, atributos, iniciativa, acoes);
}
	//====== MÉTODOS ======
    @Override
    public void usarHabilidade1() {
    	System.out.println(getNome() + "está utilizando a habilidade Barracuda(+1 em testes para obter informações)");
    	int rolagem = rolarD6();
    	int resultado = rolagem + getAtributos() + 1;
    	System.out.println("ROLAGEM : " + rolagem);
    	System.out.println("RESULTADO FINAL : " + resultado);
    }
    
    @Override
    public void usarHabilidade2() {
    	System.out.println(getNome() + "está utilizando a habilidade More Then a Feeling(direito a 2 perguntas ao mestre)");
    }
    
    //===== POLIMORFISMO =====
    @Override
    public void executarTurno() {
    	Scanner scanner = new Scanner(System.in);
        int acoesRestantes = getAcoes();
    	System.out.println("É o turno de " + getNome() + " (Negociador). Você tem " + getAcoes() + " ações.");
    	
    	while (acoesRestantes > 0) {
            System.out.println("\nAções Restantes: " + acoesRestantes);
            System.out.println("Escolha a ação...");
            System.out.println("1 - Usar Habilidade 1 (Barracuda)");
            System.out.println("2 - Usar Habilidade 2 (More Than a Feeling)");
            System.out.println("3 - Realizar Descanso (Finaliza o turno)");
            
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    usarHabilidade1();
                    acoesRestantes--; 
                    break;
                case 2:
                    usarHabilidade2();
                    acoesRestantes--; 
                    break;
                case 3:
                    realizarDescanso(); 
                    acoesRestantes = 0; 
                    System.out.println(getNome() + " realizou Descanso e terminou o turno.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
    	setAcoes(acoesRestantes);
        System.out.println("Sem ações restantes.");
        System.out.println("--- FIM DO TURNO ---");
        
        scanner.close();
    }
}
