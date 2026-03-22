package com.example.exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EchoActivity extends AppCompatActivity {

    private static final String TAG = "EchoActivityLogger";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"Successfully Started onCreate Method for Echo Activity");

        Intent RecievedIntent = getIntent();
        String RecievedMessage = RecievedIntent.getStringExtra("Message");
        TextView Echo = findViewById(R.id.EchoText);

        if(RecievedMessage != null){
            Log.d(TAG, "Successfully Recieved Message");
            Echo.setText(RecievedMessage);
        }else{
            Log.w(TAG,"Text Not Recieved");
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.echo_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}