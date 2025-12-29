package br.com.ProjetoFinal.poo.codigo;

public abstract class Jogador extends Entidade {

	    // ===== ATRIBUTOS =====
	    private int atributos;
	    private int iniciativa;
	    private int acoes;

	    // ===== CONSTRUTOR =====
	    public Jogador(String nome, int vida, String equipamentos, int defesa,
	                   int atributos, int iniciativa, int acoes) {

	        super(nome, vida, equipamentos, defesa);
	        this.atributos = atributos;
	        this.iniciativa = iniciativa;
	        this.acoes = acoes;
	    }

	    // ==== GETTERS E SETTERS ====

	    public int getAtributos() {
	        return atributos;
	    }

	    public void setAtributos(int atributos) {
	        this.atributos = atributos;
	    }

	    public int getIniciativa() {
	        return iniciativa;
	    }

	    public void setIniciativa(int iniciativa) {
	        this.iniciativa = iniciativa;
	    }

	    public int getAcoes() {
	        return acoes;
	    }

	    public void setAcoes(int acoes) {
	        this.acoes = acoes;
	    }

	    // ===== MÉTODOS ABSTRATOS =====
	    public abstract void usarHabilidade1();
	    public abstract void usarHabilidade2();

	    // ===== MÉTODO CONCRETO =====
	    public void realizarDescanso() {
	        this.acoes = 3;
	    }

	    // ===== POLIMORFISMO =====
	    @Override
	    public void executarTurno() {
	    
	    }
}
