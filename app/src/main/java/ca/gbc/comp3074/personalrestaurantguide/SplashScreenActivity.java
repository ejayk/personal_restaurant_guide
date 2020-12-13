package ca.gbc.comp3074.personalrestaurantguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //timer function for splashscreen.
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), RestaurantsActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}