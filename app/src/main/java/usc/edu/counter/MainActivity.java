package usc.edu.counter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int Count_Val = 0;
    TextView Counter = findViewById(R.id.Counter);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button AddCounter = findViewById(R.id.button);
        Counter.setText(String.valueOf(Count_Val));

        AddCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count_Val++;
                Counter.setText(String.valueOf(Count_Val));
            }
        });
        // Sabotage Code
        TextView counterDisplay = null;
        counterDisplay.setText("0");

    }
    protected void onSavedInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("Counter_Val", Count_Val);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Count_Val = savedInstanceState.getInt("Counter_Val");
        Counter.setText(String.valueOf(Count_Val));
    }
}
