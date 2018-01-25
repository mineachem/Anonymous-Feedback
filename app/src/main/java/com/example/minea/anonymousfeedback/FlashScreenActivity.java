package com.example.minea.anonymousfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FlashScreenActivity extends AppCompatActivity {

    private TextView title;
    private ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        title = findViewById(R.id.title_mad);
        logo = findViewById(R.id.logo_mad);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        title.startAnimation(myanim);
        logo.startAnimation(myanim);

        final Intent choicesActivity = new Intent(this,ChoicesActivity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                finally {
                    startActivity(choicesActivity);
                    finish();
                }
            }
        };
            timer.start();
    }
}
