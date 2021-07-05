package com.konstantin_romashenko.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_flash;
    private FlashClass flash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init()
    {
        button_flash = findViewById(R.id.b1);
        flash = new FlashClass(this);
    }

    public void onClickFlash(View view)
    {
        if(flash.isFlash_status())
        {
            flash.flashOff();
            button_flash.setText("On");
            button_flash.setBackgroundResource(R.drawable.circle_red);
        }
        else
        {
            flash.flashOn();
            button_flash.setText("Off");
            button_flash.setBackgroundResource(R.drawable.circle_green);
        }

    }

    public void onDestroy() {

        super.onDestroy();
        if(flash.isFlash_status())
            flash.flashOff();
    }
}