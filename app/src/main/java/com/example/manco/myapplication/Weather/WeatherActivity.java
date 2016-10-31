//package com.example.manco.myapplication.Weather;
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import com.example.manco.myapplication.R;
//
//
//public class WeatherActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.root, new WeatherFragment())
//                    .commit();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//
//
//		int id = item.getItemId();
//		if (id == R.id.refresh) {
//		}
//
//        if(item.getItemId() == R.id.change_city){
//            changeCity();
//        }
//        return false;
//   }
//
//    public void changeCity(){
//        CustomDialog dialog = new CustomDialog(this,this);
//    }
//
//    public void setCity(String city){
//        WeatherFragment wf = (WeatherFragment)getSupportFragmentManager()
//                .findFragmentById(R.id.root);
//
//        wf.changeCity(city);
//        new CityPreference(this).setCity(city);
//    }
//}