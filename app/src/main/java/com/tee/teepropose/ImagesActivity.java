package com.tee.teepropose;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_images)
public class ImagesActivity extends AppCompatActivity {

    private ImageView firstImage;
    private ImageView secondImage;
    private ImageView thirdImage;
    private ImageView fourthImage;
    private ImageView fifthImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        firstImage = (ImageView) findViewById(R.id.image_first);
        secondImage = (ImageView) findViewById(R.id.image_second);
        thirdImage = (ImageView) findViewById(R.id.image_third);
        fourthImage = (ImageView) findViewById(R.id.image_fourth);
        fifthImage = (ImageView) findViewById(R.id.image_fifth);


    }
}
