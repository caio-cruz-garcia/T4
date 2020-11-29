package com.company.model;

/**
 * Class Equipment, made to represent an Equipment that a Character (Personagem) may have.
 * @version 0.1
 * @since 2020-11-28
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
public class Equipment {
    // Vars
    String name;
    String desc;
    String stat;

    /**
     * Constructor for equipment
     * @param name Name of equipment
     * @param desc Description of equipment
     * @param stat Stats of equipment
     */
    public Equipment(String name, String desc, String stat) {
        this.name = name;
        this.desc = desc;
        this.stat = stat;
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
     * method getStat
     * @return Stat
     */
    public String getStat() {
        return stat;
    }

    /**
     * method setStat
     * @param stat Set stat
     */
    public void setStat(String stat) {
        this.stat = stat;
    }
}
