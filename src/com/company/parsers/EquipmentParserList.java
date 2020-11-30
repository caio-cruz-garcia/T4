package com.company.parsers;

import com.company.model.Equipment;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * class EquipmentParserList, made to parse the JSON data related to Equipment as a list
 *
 * @version 0.1
 * @since 2020-11-30
 */

/*
Update log.:
Update 0.:
- Added update log
- Added javadoc comment

Update 0.1.:
- Added toJson (Template)
- Added fromJson (Template)
 */
public class EquipmentParserList {

    /**
     * Takes a list pokemoncardlist to convert into json
     * @param equipmentList equipmentList
     * @return Json
     */
    public static JSONArray toJson(List<Equipment> equipmentList){
        JSONArray json = new JSONArray();
        equipmentList.forEach( card -> {
            json.put(EquipmentParser.toJson(card));
        });
        return json;
    }

    /**
     * Takes a json array and convert it into a pokemoncardlist
     * @param json Takes a JSONArray to convert into cardList
     * @return PokemonCardList
     */
    public static List<Equipment> fromJson(JSONArray json){
        List<Equipment> equipmentList = new ArrayList<>();
        json.forEach( item ->{
            equipmentList.add(EquipmentParser.fromJson((JSONObject) item));
        });
        return equipmentList;
    }
}
