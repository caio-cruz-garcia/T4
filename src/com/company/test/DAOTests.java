package com.company.test;

import com.company.dao.EquipmentDAO;
import com.company.model.Equipment;
import com.company.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class DAOTests {
    public static void main(String[] args) {
        EquipmentDAO equipmentDAO = new EquipmentDAO();

        for (Personagem perso: equipmentDAO.getALL()) {
            equipmentDAO.delete(perso);
        }

        Personagem personagem = new Personagem("Test char");
        List<Personagem> personagems;
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new Equipment("Dentadura de ataque", "Equipamento bocal", "+5 de nojo"));
        equipmentList.add(new Equipment("Varinha mágica moderna", "Revolver - Dano físico", "Casuais não conseguem bloquear"));
        equipmentList.add(new Equipment("Capacete de berserk", "Nao sei onde estou, não sei quem eu sou. Sei apenas que preciso lutar", "+20 armadura, -5 visão"));

        personagem.setEquipmentList(equipmentList);
        equipmentDAO.create(personagem);
        personagems = equipmentDAO.getALL();
        for (Equipment equipment:personagems.get(0).getEquipmentList()) {
            System.out.println(equipment.getName());
            System.out.println(equipment.getDesc());
            System.out.println(equipment.getStat());
            System.out.println("-----------------------------------");
        }

        equipmentDAO.delete(personagem);

    }
}
