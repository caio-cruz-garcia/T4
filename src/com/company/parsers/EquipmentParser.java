package com.company.parsers;
import com.company.model.Equipment;
import org.json.JSONObject;

/**
 * class EquipmentParser, made to parse the JSON data related to Equipment
 *
 * @version 0
 * @since 2020-11-30
 */

/*
Update log.:
Update 0.:
- Added update log
- Added javadoc comment
- Added toJson
- Added fromJson
 */
public class EquipmentParser {

    /**
     * Converts an Equipment into Json
     * @param equipment Equipment class
     * @return Json
     */
    public static JSONObject toJson(Equipment equipment){
        JSONObject json = new JSONObject();
        json.put("name", equipment.getName());
        json.put("desc", equipment.getDesc());
        json.put("stat", equipment.getStat());
        return json;
    }

    /**
     * Converts a Json into Equipment
     * @param json Json
     * @return Equipment
     */
    public static Equipment fromJson(JSONObject json){
        Equipment equipment = new Equipment(
                json.getString("name"),
                json.getString("desc"),
                json.getString("stat")
        );
        return equipment;
    }
}
