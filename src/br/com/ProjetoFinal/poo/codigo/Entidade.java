package br.com.ProjetoFinal.poo.codigo;

public abstract class Entidade {
    private String nome;
    private int vida;
    private String equipamentos;
    private int defesa;

    public Entidade(String nome, int vida, String equipamentos, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.equipamentos = equipamentos;
        this.defesa = defesa;
    }

    public abstract void executarTurno();

    // Getters e Setters
    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public String getEquipamentos() { return equipamentos; }
    public int getDefesa() { return defesa; }
}