package br.com.ProjetoFinal.poo.codigo;

public class Cavalo extends Entidade {
	private int dano;
	private int potencia;
	private int vigor;
	
	// ===== CONSTRUTOR VAZIO (OBRIGATÓRIO) =====
    public Cavalo() {
        super("Cavalo", 15, "Nenhum", 5);
    }
    
    // ===== CONSTRUTOR COM ARGUMENTOS =====
    public Cavalo(String nome, int vida, String equipamentos, int defesa,
            int dano, int potencia, int vigor) {
    	
  super(nome, vida, equipamentos, defesa);
  
  this.dano = dano;
  this.potencia = potencia;
  this.vigor = vigor;
  }
    // ===== POLIMORFISMO =====
    @Override
    public void executarTurno() {

    }
}