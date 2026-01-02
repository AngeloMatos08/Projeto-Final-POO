package br.com.ProjetoFinal.poo.codigo;

import java.util.Scanner;

public class Curador extends Jogador{
	//===== CONSTRUTORES =====
	public Curador(String nome, int vida, String equipamentos, int defesa, int atributos, int iniciativa, int acoes) {
		
		super(nome, vida, equipamentos, defesa, atributos, iniciativa, acoes);
		}
	//====== MÉTODOS ======
	@Override
	public void usarHabilidade1() {
		System.out.println(getNome() + "está utilizando a habilidade Fortunate Son(cura 3 PV's.)");
		setVida(getVida() + 3);
	}
	
	@Override
	public void usarHabilidade2() {
		System.out.println(getNome() + "está utilizando a habilidade I Want to Hold Your Hand(+ 1d6 PV's curados durante o descanso)");
	}
	
	@Override
	public void realizarDescanso() {
		super.realizarDescanso();
		
		int rolagem = rolarD6();
		setVida(getVida() + rolagem);
		
		usarHabilidade2();
		
		System.out.println("Você curou " + rolagem + " PV's.");
		System.out.println("Vida atual : " + getVida());
	}
	
	//===== POLIMORFISMO =====
	@Override
	public void executarTurno() {
		Scanner scanner = new Scanner(System.in);
		int acoesRestantes = getAcoes();
		System.out.println("É o turno de " + getNome() + " (Curador). Você tem " + getAcoes() + " ações.");
		
		while (acoesRestantes > 0) {
			System.out.println("\nAções Restantes: " + acoesRestantes);
			System.out.println("Escolha a ação...");
			System.out.println("1 - Usar Habilidade 1 (Fortunate Son)");
			System.out.println("2 - Realizar Descanso (Finaliza o turno)");
			
			int escolha = scanner.nextInt();
			switch (escolha) {
			case 1:
				usarHabilidade1();
				acoesRestantes--;
				break;
			case 2:
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