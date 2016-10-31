package com.example.manco.myapplication.Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * Created by Marjan, Tim, Robin, Khaled on 2016-10-17.
 */

public class Parser<T> {
    final Class<T> typeParameterClass;

    public Parser(Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    private static Gson gson = new GsonBuilder().create();

    public T getObject(String jsonString) {
        try {
            return gson.fromJson(jsonString, typeParameterClass);
        } catch (Exception e) {
            //prompt error
            return null;
        }
    }
}
