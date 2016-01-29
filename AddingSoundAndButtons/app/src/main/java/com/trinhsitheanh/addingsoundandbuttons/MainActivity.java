package com.trinhsitheanh.addingsoundandbuttons;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener
{

    TextView txt;
    RadioGroup grp1,grp2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.button_1);
        btn = (Button) findViewById(R.id.btnClick);
        txt = (TextView) findViewById(R.id.textView);
        grp1 = (RadioGroup) findViewById(R.id.grp1);
        grp2 = (RadioGroup) findViewById(R.id.grp2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("Random");
                mediaPlayer.start();
                InputStream inputStream = getResources().openRawResource(R.drawable.daisies);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                try {
                    getApplicationContext().setWallpaper(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        grp1.setOnCheckedChangeListener(this);
        grp2.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.txtNormal:
                txt.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL),Typeface.NORMAL);
                break;
            case R.id.txtItalic:
                txt.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC),Typeface.ITALIC);
                break;
            case R.id.txtBold:
                txt.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD),Typeface.BOLD);
                break;
            case R.id.left:
                txt.setGravity(Gravity.LEFT);
                break;
            case R.id.right:
                txt.setGravity(Gravity.RIGHT);
                break;
            case R.id.center:
                txt.setGravity(Gravity.CENTER);
                break;
        }

    }
}
