4a

activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <ImageView
        android:id="@+id/imgCamera"
        android:layout_width="400dp"
        android:layout_height="240dp"
        android:scaleType="fitXY" />
    <Button
        android:id="@+id/btnCamera"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="21dp"
        android:text="Open Camera"/>

</LinearLayout>

MainActivity.java

package com.example.camerasd;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final int CAMERA_REQ_CODE = 100;
    ImageView imgCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCamera = findViewById(R.id.imgCamera);
        Button btnCamera = findViewById(R.id.btnCamera);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iCamera, CAMERA_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == CAMERA_REQ_CODE) {
                //for camera
                Bitmap img = (Bitmap) (data.getExtras().get("data"));
                imgCamera.setImageBitmap(img);

            }
        }
    }

}



*****************4b********************
package com.example.myapplication4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button b;
    private final int MY_REQ_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.btn);
        img = findViewById(R.id.img);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_PICK);
                i.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i,MY_REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == MY_REQ_CODE){
                img.setImageURI(data.getData());
            }
        }
    }
}

***************XML**************

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="10dp"
    tools:context=".MainActivity">

    <ImageView
        android:layout_width="410dp"
        android:layout_height="400dp"
        android:id="@+id/img"
        android:scaleType="fitXY"
        />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/btn"
        android:layout_marginTop="420dp"
        android:text="Open Gallery"
        android:layout_centerHorizontal="true"/>

</RelativeLayout>
