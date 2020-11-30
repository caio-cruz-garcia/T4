package com.company.model;

import java.util.List;

/**
 * Class model for Personagem.
 * Represents what a character may be.
 */
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
    // Bonus
    private List<Equipment> equipmentList;
    private List<Items> itemsList;


    /**
     * First constructor for Personagem.
     * @param nome Represents the name
     * @param raca Represents the race
     * @param profissao Represents the career
     * @param mana Represents the mana
     * @param ataque Represents the attack
     * @param ataque_magico Represents the magical attack
     * @param defesa Represents the defense
     * @param defesa_magica Represents the magical defense
     * @param velocidade Represents the velocity
     * @param destreza Represents the dexterity
     * @param exp Represents the exp
     * @param nivel Represents the level
     */
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

    /**
     * Second constructor, creates a new character with empty values
     * @param nome
     */
    public Personagem(String nome){
        this(nome,null,null,0,0,0,0,0,0,0,0,0);
    }

    /**
     * toString
     * @return data in the toString format
     */
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

    /**
     * method getNome.
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * method getRaca
     * @return raca
     */
    public String getRaca() {
        return raca;
    }

    /**
     * method getProfissao
     * @return profissao
     */
    public String getProfissao() {
        return profissao;
    }

    /**
     * method getmana
     * @return mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * method getAtaque
     * @return ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * method getAtaque_magico
     * @return ataque_magico
     */
    public int getAtaque_magico() {
        return ataque_magico;
    }

    /**
     * method getDefesa
     * @return defesa
     */
    public int getDefesa() {
        return defesa;
    }

    /**
     * method getDefesa_magica
     * @return defesa_magica
     */
    public int getDefesa_magica() {
        return defesa_magica;
    }

    /**
     * method getVelocidade
     * @return velocidade
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * method getDestreza
     * @return destreza
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * method getExp
     * @return exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * method getNivel
     * @return nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * method setNome
     * @param nome set new name
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * method setRaca
     * @param raca set new raca
     */
    public void setRaca(String raca) {
        this.raca = raca;
    }

    /**
     * method setProfissao
     * @param profissao set new profissao
     */
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    /**
     * method setMana
     * @param mana set new mana
     */
    public void setMana(int mana) {
        this.mana = mana;
    }

    /**
     * method setAtaque
     * @param ataque set new ataque
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * method setAtaque_magico
     * @param ataque_magico set new Ataque_magico
     */
    public void setAtaque_magico(int ataque_magico) {
        this.ataque_magico = ataque_magico;
    }

    /**
     * method setDefesa
     * @param defesa set new defesa
     */
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    /**
     * method defesa_magica
     * @param defesa_magica set new defesa_magica
     */
    public void setDefesa_magica(int defesa_magica) {
        this.defesa_magica = defesa_magica;
    }

    /**
     * method setVelocidade
     * @param velocidade set new velocity
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * method setDestreza
     * @param destreza set new destreza
     */
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    /**
     * method setExp
     * @param exp set new exp
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * method setNivel
     * @param nivel set new nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * method getEquipmentList
     * @return list of equipment
     */
    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    /**
     * method setEquipmentList
     * @param equipmentList set new list of equipment
     */
    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    /**
     * method getItemsList
     * @return list of items
     */
    public List<Items> getItemsList() {
        return itemsList;
    }

    /**
     * method setItemsList
     * @param itemsList set new list of items
     */
    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }
}
