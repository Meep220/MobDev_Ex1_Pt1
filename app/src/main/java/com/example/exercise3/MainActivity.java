package com.example.exercise3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityLogger";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"Successfully Started onCreate Method for Main Activity");

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button Send = findViewById(R.id.button);
        EditText Message = findViewById(R.id.MessageText);
        Button SMS = findViewById(R.id.SMS);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"Successfully Started onClick Method to Send Message to Echo Activity");
                Intent NewIntent = new Intent(MainActivity.this, EchoActivity.class);
                String EchoMessage = Message.getText().toString();
                NewIntent.putExtra("Message",EchoMessage);
                startActivity(NewIntent);
            }
        });
        SMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Sending SMS Message");
                Intent NewIntent = new Intent(Intent.ACTION_SEND);
                String EchoMessage = Message.getText().toString();
                NewIntent.putExtra(Intent.EXTRA_TEXT,EchoMessage);
                NewIntent.setType("text/plain");
                Intent SMSIntent = Intent.createChooser(NewIntent, null);
                startActivity(SMSIntent);
            }
        });

    }
}