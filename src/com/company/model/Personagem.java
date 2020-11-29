package com.company.model;

public class Personagem {
    private String nome;
    private String raca;
    private String profissao;
    private int mana;
    private int ataque;
    private int ataque_magico;
    private int defesa;
    private int defesa_magica;
    private int velocidade;
    private int destreza;
    private int exp;
    private int nivel;

    public Personagem(String nome, String raca, String profissao, int mana, int ataque, int ataque_magico, int defesa, int defesa_magica, int velocidade, int destreza, int exp, int nivel) {
        this.nome = nome;
        this.raca = raca;
        this.profissao = profissao;
        this.mana = mana;
        this.ataque = ataque;
        this.ataque_magico = ataque_magico;
        this.defesa = defesa;
        this.defesa_magica = defesa_magica;
        this.velocidade = velocidade;
        this.destreza = destreza;
        this.exp = exp;
        this.nivel = nivel;
    }

    public Personagem(String nome){
        this(nome,null,null,0,0,0,0,0,0,0,0,0);
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", profissao='" + profissao + '\'' +
                ", mana=" + mana +
                ", ataque=" + ataque +
                ", ataque_magico=" + ataque_magico +
                ", defesa=" + defesa +
                ", defesa_magica=" + defesa_magica +
                ", velocidade=" + velocidade +
                ", destreza=" + destreza +
                ", exp=" + exp +
                ", nivel=" + nivel +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public String getProfissao() {
        return profissao;
    }

    public int getMana() {
        return mana;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaque_magico() {
        return ataque_magico;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getDefesa_magica() {
        return defesa_magica;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getExp() {
        return exp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setAtaque_magico(int ataque_magico) {
        this.ataque_magico = ataque_magico;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setDefesa_magica(int defesa_magica) {
        this.defesa_magica = defesa_magica;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
