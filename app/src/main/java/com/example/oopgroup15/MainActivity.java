package com.example.oopgroup15;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnHome, btnAbout, btnFaq, btnCamera;
    RelativeLayout mainLayout;

    private static final int CAMERA_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect Java variables to XML components
        btnHome = findViewById(R.id.btnHome);
        btnAbout = findViewById(R.id.btnAbout);
        btnFaq = findViewById(R.id.btnFaq);
        btnCamera = findViewById(R.id.btnCamera);

        mainLayout = findViewById(R.id.mainLayout);

        // HOME button
        btnHome.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                // Already on home page, so do nothing
            }
        });

        // ABOUT button
        btnAbout.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                Intent intent =
                        new Intent(MainActivity.this,
                                AboutActivity.class);

                startActivity(intent);
            }
        });

        // FAQ button
        btnFaq.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                Intent intent =
                        new Intent(MainActivity.this,
                                FAQActivity.class);

                startActivity(intent);
            }
        });

        // CAMERA button
        btnCamera.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                Intent cameraIntent =
                        new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST &&
                resultCode == RESULT_OK &&
                data != null) {

            Bitmap photo =
                    (Bitmap) data.getExtras().get("data");

            BitmapDrawable drawable =
                    new BitmapDrawable(getResources(), photo);

            mainLayout.setBackground(drawable);
        }
    }
}