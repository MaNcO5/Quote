package com.example.manco.myapplication.Weather;


import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Marjan, Tim, Robin, Khaled on 2016-10-17.
 */
public class CityPreference {

    SharedPreferences prefs;



    public CityPreference(Activity activity) {
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
        }


    public String getCity() {
        return prefs.getString("city", "Malmö");
        }


    public void setCity(String city) {
        prefs.edit().putString("city", city).commit();
        }
}
