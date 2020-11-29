package com.company.model;

/**
 * Class items, made to represent an Item that a Character (Personagem) may have.
 * @version 0.1
 * @since 2020-11-29
 */
/*
Update 0.:
- Class created
- Javadoc comment added
- Log created

Update 0.1.:
- Added vars
- Added constructor
- Added getters and setters
 */
public class Items {
    // Vars
    String name;
    String desc;
    int quantity;

    /**
     * Constructor for items
     * @param name Name of item
     * @param desc Desc of item
     */
    public Items(String name, String desc) {
        this.name = name;
        this.desc = desc;
        quantity = 0;
    }

    /**
     * method getName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method setName
     * @param name Set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method getDesc
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * method setDesc
     * @param desc Set desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * method getQuantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * method setQuantity
     * @param quantity Set quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
