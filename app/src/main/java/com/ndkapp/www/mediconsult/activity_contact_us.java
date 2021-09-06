package com.ndkapp.www.mediconsult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_contact_us extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    ImageView i1;
    ImageView i2;
    ImageView i3;
    private static final int REQUEST_CALL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        t1 = findViewById(R.id.call_cs);
        t2 = findViewById(R.id.mail_cs);
        t3 = findViewById(R.id.map_cs);
        i1 = findViewById(R.id.final_call);
        i2 = findViewById(R.id.final_mail);
//        i3 = findViewById(R.id.final_map);

        final String num = "7774962061";
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(num);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "hbagul16@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:" + "hbagul16@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Query or Feedback");
                try {
                    startActivity(Intent.createChooser(i, "Choose an Email client :"));
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(activity_contact_us.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/dir/21.2837112,74.7454108/P.E.S.+Modern+College+of+Engineering,+1186%2FA,+Off+J.M.+Road,+Shivaji+nagar,+Sumukh+Society,+Shivajinagar,+Pune,+Maharashtra+411005,+India/@19.9001931,73.1970059,8z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x3bc2c07e4111123b:0x3f92335c2e5c8400!2m2!1d73.8464113!2d18.5255643"));
                startActivity(bIntent);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bIntent = new Intent(Intent.ACTION_VIEW);
                bIntent.setData(Uri.parse("https://www.google.com/maps/dir/21.2837112,74.7454108/P.E.S.+Modern+College+of+Engineering,+1186%2FA,+Off+J.M.+Road,+Shivaji+nagar,+Sumukh+Society,+Shivajinagar,+Pune,+Maharashtra+411005,+India/@19.9001931,73.1970059,8z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x3bc2c07e4111123b:0x3f92335c2e5c8400!2m2!1d73.8464113!2d18.5255643"));
                startActivity(bIntent);
            }
        });


    }

    private void makePhoneCall(String num)
    {
        if(ContextCompat.checkSelfPermission(activity_contact_us.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(activity_contact_us.this, new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL );
        }
        else
        {
            String dial = "tel:" +num;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
    }

}
