activitymain.xml:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.smsemailphone.MainActivity">
    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Sending SMS Example"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:textSize="30dp" />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Sms"
        android:id="@+id/btnSendSMS"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="48dp" />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Send Email"
        android:id="@+id/btnSendEmail"
        android:layout_below="@+id/btnSendSMS"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="48dp" />
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Phone"
        android:id="@+id/btnDialPhone"
        android:layout_marginTop="54dp" />
</RelativeLayout>

MainActivity:
package com.example.smsemailphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    Button sendBtn;
    Button btnSendEmail;
    Button btnPhone;
    String phoneNo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.btnSendSMS);
        btnSendEmail = (Button) findViewById(R.id.btnSendEmail);
        btnPhone = (Button) findViewById(R.id.btnDialPhone);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();

            }
});
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneDial();
            }
        });
    }
    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ba.mohan@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject Test");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Message Body Test");
        startActivity(emailIntent);
    }
    protected void sendSMSMessage() {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("sms_body", "default content");
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);
        Toast.makeText(getApplicationContext(), "SMS sent.",
                Toast.LENGTH_LONG).show();
    }
    protected void PhoneDial() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent); }
}
