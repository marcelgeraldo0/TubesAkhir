package com.example.tubesakhir.View;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.tubesakhir.R;

import java.util.Random;
public class FragmentDudukKecil implements AppCompatActivity{

    public static final String TAG = "FragmentDudukKecil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Intent get=getIntent();
        Random r = new Random(SystemClock.uptimeMillis());
        final int a1 = r.nextInt(10000000) % 4;
        final int a2 = r.nextInt(10000000) % 4;
        final int a3 = r.nextInt(10000000) % 4;
        final int a4 = r.nextInt(10000000) % 4;
        final Button b1, b2, b3, b4, b6, b7, b8, b9, b10 ;
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        b10= (Button) findViewById(R.id.btn10);
        switch (a1) {
            case 0:
                b1.setBackgroundResource(R.color.Black);
                break;
            case 1:
                b2.setBackgroundResource(R.color.Black);
                break;
            case 2:
                b3.setBackgroundResource(R.color.Black);
                break;
            case 3:
                b4.setBackgroundResource(R.color.Black);
                break;
        }
        switch (a2) {
            case 0:
                b6.setBackgroundResource(R.color.Black);
                break;
            case 1:
                b7.setBackgroundResource(R.color.Black);
                break;
            case 2:
                b8.setBackgroundResource(R.color.Black);
                break;
            case 3:
                b9.setBackgroundResource(R.color.Black);
                break;
        }

    }

}
