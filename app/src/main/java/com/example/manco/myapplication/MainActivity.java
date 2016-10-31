package com.example.manco.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.manco.myapplication.Entity.Quote;
import com.example.manco.myapplication.HttpController.CustomCallBack;
import com.example.manco.myapplication.HttpController.HttpClient;
import com.example.manco.myapplication.Runnable.QuoteRunnable;
import com.example.manco.myapplication.Weather.CityPreference;
import com.example.manco.myapplication.Weather.CustomDialog;
import com.example.manco.myapplication.Weather.WeatherFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Marjan, Tim, Robin, Khaled on 2016-10-17.
 */
public class MainActivity extends AppCompatActivity {
    @Bind(R.id.quote)
    TextView quote;
    @Bind(R.id.author)
    TextView author;
    @Bind(R.id.root)
    View root;

    CustomCallBack httpCallBack;
    QuoteRunnable quoteRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //....
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        quoteRunnable = new QuoteRunnable(author, quote);
        httpCallBack = new CustomCallBack(Quote.class, quoteRunnable, this);
        HttpClient.makeRequest("http://quotes.stormconsultancy.co.uk/random.json", httpCallBack);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpClient.makeRequest("http://quotes.stormconsultancy.co.uk/random.json", httpCallBack);
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.root, new WeatherFragment())
                    .commit();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            //Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }



        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.


            int id = item.getItemId();
            if (id == R.id.refresh) {

                setCity(new CityPreference(this).getCity());

                Toast.makeText(this,
                        "Updated",
                        Toast.LENGTH_LONG).show();

            }
            if (item.getItemId() == R.id.change_city) {
                changeCity();
            }
            return false;
        }

    /**
     * Visar en dialogruta där man kan ändra stad
     */
    public void changeCity() {
        CustomDialog dialog = new CustomDialog(this, this);
    }

    /**
     * Ändrar vilken stad som ska visas. Sparas i shared preferences
     * @param city
     */
    public void setCity(String city) {
        WeatherFragment wf = (WeatherFragment) getSupportFragmentManager()
                .findFragmentById(R.id.root);

        wf.changeCity(city);
        new CityPreference(this).setCity(city);
    }
}

