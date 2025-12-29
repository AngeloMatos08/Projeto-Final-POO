package br.com.ProjetoFinal.poo.codigo;

public abstract class Entidade {
	 // ===== ATRIBUTOS =====
    private String nome;
    private int vida;
    private String equipamentos;
    private int defesa;

    // uso de static e final
    public static final int DADO_LADOS = 6;

    // ===== CONSTRUTOR =====
    public Entidade(String nome, int vida, String equipamentos, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.equipamentos = equipamentos;
        this.defesa = defesa;
    }

    // ===== MÉTODOS =====
    public int rolarD6() {
        return (int) (Math.random() * DADO_LADOS) + 1;
    }

    public abstract void executarTurno();

    // ===== GETTERS / SETTERS =====
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefesa() {
        return defesa;
    }
}
