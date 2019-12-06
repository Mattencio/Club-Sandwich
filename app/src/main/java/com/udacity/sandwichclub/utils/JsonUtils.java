package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwich = new JSONObject(json);

        JSONObject name = sandwich.getJSONObject("name");
        String mainName = name.getString("mainName");
        String placeOfOrigin = sandwich.getString("placeOfOrigin");
        String description = sandwich.getString("description");
        String image = sandwich.getString("image");

        List<String> alsoKnownAs = jsonArrayToList(name, "alsoKnownAs");
        List<String> ingredients = jsonArrayToList(sandwich, "ingredients");

        return new Sandwich(mainName,
                alsoKnownAs,
                placeOfOrigin,
                description,
                image,
                ingredients);
    }

    private static List<String> jsonArrayToList(JSONObject jsonObject, String parameter) throws JSONException {
        List<String> newList = new ArrayList<>();
        JSONArray alsoKnownAsArray = jsonObject.getJSONArray(parameter);

        for (int i = 0; i < alsoKnownAsArray.length(); i++) {
            newList.add(alsoKnownAsArray.getString(i));
        }

        return newList;
    }
}
