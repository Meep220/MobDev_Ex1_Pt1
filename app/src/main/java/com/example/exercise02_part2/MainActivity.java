package com.example.exercise02_part2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exercise02_part2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        binding.Submit.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin(){
        String StudID = binding.SchoolId.getText().toString();
        String Pass = binding.Password.getText().toString();

        if(StudID.equals("20102827") && Pass.equals("brown27")){
            binding.Result.setText(getString(R.string.Result));
        }else{
            binding.Result.setText(getString(R.string.Failed));
        }

    }

}