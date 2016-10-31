package com.example.manco.myapplication.Weather;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.manco.myapplication.MainActivity;
import com.example.manco.myapplication.R;

/**
 * Created by Marjan, Tim, Robin, Khaled on 2016-10-17.
 */
public class CustomDialog {

    private MainActivity weather;
    private EditText city;

    /**
     * Dialogruta där användaren kan ändra vilken stad som vädret ska visa
     * @param context
     * @param weather
     */
    public CustomDialog(Context context, MainActivity weather) {

        this.weather = weather;

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Info");

        // set the custom dialog components - text, image and button
        city = (EditText) dialog.findViewById(R.id.etCity);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setText();

                dialog.dismiss();
            }
        });

        dialog.show();
    }



    public void setText(){

        weather.setCity(city.getText().toString());

    }
}
