package com.example.mock_midterms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mock_midterms.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding Binding;
    public final static String TAG = "MainActivityTag";
    float OpA = 0;
    float OpB = 0;
    float Result;
    String Operator = null;
    float Calculate(){
        if(Operator.equals("+")){
            Log.d(TAG,"Performing Addition Operation");
            Result = OpA + OpB;
            Log.d(TAG,"Result is :" + Result);
        } else if (Operator.equals("-")) {
            Log.d(TAG,"Performing Subtraction Operation");
            Result = OpA - OpB;
            Log.d(TAG,"Result is :" + Result);
        } else if (Operator.equals("*")) {
            Log.d(TAG,"Performing Multiplication Operation");
            Result = OpA * OpB;
            Log.d(TAG,"Result is :" + Result);
        } else if (Operator.equals("/")) {
            // Division
            Log.d(TAG,"Performing Division Operation");
            if(OpB == 0){
                // Toast to prompt divide by zero
                Toast.makeText(this,"Cannot Divide by Zero",Toast.LENGTH_SHORT).show();
            }else{
                Result = OpA / OpB;
            }
            Log.d(TAG,"Result is :" + Result);
        } else if (Operator.equals("ID")) {
            // Custom Operator
            Log.d(TAG, "Performing Custom Operation");
            float ID_1 = 8;
            float ID_2 = 2;
            float ID_3 = 7;
            Result = ((OpA + ID_1) * ID_2) / ID_3;
        }else{
            return Result;
        }
        return Result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(Binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        List<Button> numButtons = Arrays.asList(
                Binding.num0, Binding.num1, Binding.num2, Binding.num3, Binding.num4,
                Binding.num5, Binding.num6, Binding.num7, Binding.num8, Binding.num9
        );

        for (int i = 0; i < numButtons.size(); i++) {
            String digit = String.valueOf(i);
            numButtons.get(i).setOnClickListener(v -> Binding.Input.append(digit));
        }

        Binding.Addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Binding.Input.getText().equals("")){
                    return;
                }
                else{
                    Log.d(TAG,"Successfully Started Addition Method");
                    OpA = (Binding.Input.getText() == "")? 0 :Float.parseFloat(Binding.Input.getText().toString());
                    Operator = "+";
                    Log.d(TAG,"Successfully Assigned Float Value:" + OpA);
                    Binding.Input.append(" + ");
                    Binding.Equation.append(Binding.Input.getText().toString());
                    Binding.Input.setText("");
                }
            }
        });
        Binding.Subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Binding.Input.getText().equals("")){
                    return;
                }else{
                    Log.d(TAG,"Successfully Started Subtraction Method");
                    OpA = (Binding.Input.getText() == "")? 0 :Float.parseFloat(Binding.Input.getText().toString());
                    Operator = "-";
                    Log.d(TAG,"Successfully Assigned Float Value:" + OpA);
                    Binding.Input.append(" - ");
                    Binding.Equation.append(Binding.Input.getText().toString());
                    Binding.Input.setText("");
                }
            }
        });
        Binding.Multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Binding.Input.getText().equals("")){
                    return;
                }else{
                    Log.d(TAG,"Successfully Started Multiplication Method");
                    OpA = (Binding.Input.getText() == "")? 0 :Float.parseFloat(Binding.Input.getText().toString());
                    Operator = "*";
                    Log.d(TAG,"Successfully Assigned Float Value:" + OpA);
                    Binding.Input.append(" * ");
                    Binding.Equation.append(Binding.Input.getText().toString());
                    Binding.Input.setText("");
                }
            }
        });
        Binding.Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Binding.Input.getText().equals("")){
                    return;  
                }else {
                    Log.d(TAG, "Successfully Started Division Method");
                    OpA = (Binding.Input.getText() == "") ? 0 : Float.parseFloat(Binding.Input.getText().toString());
                    Operator = "/";
                    Log.d(TAG, "Successfully Assigned Float Value:" + OpA);
                    Binding.Input.append(" / ");
                    Binding.Equation.append(Binding.Input.getText().toString());
                    Binding.Input.setText("");
                }
            }
        });
        Binding.equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Binding.Input.getText().toString().isEmpty()){
                    return;
                }
                if(Operator == null){
                    // Prevents App From Crashing if Enter is pressed after an input without an operator
                    return;
                }
                    OpB = (Binding.Input.getText() == "")? 0 :Float.parseFloat(Binding.Input.getText().toString());
                    Binding.Equation.append(Binding.Input.getText().toString());
                    Binding.Equation.append(" = ");
                    float CalculatedResult = Calculate();
                    Binding.Input.setText(String.format("%s", CalculatedResult));
            }
        });
        Binding.AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpB = 0;
                OpA = 0;
                Operator = null;
                Result = 0;
                Binding.Equation.setText("");
                Binding.Input.setText("");
            }
        });
        Binding.ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Binding.Input.getText().equals("")){
                    return;
                }else {
                    Log.d(TAG, "Successfully Started Division Method");
                    OpA = (Binding.Input.getText() == "") ? 0 : Float.parseFloat(Binding.Input.getText().toString());
                    Operator = "ID";
                    Log.d(TAG, "Successfully Assigned Float Value:" + OpA);
                    float CustomResult = Calculate();
                    Binding.Equation.append(Binding.Input.getText().toString());
                    Binding.Input.setText(String.format("%s",CustomResult));
                }
            }
        });



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("Operand_A",OpA);
        outState.putFloat("Operand_B",OpB);
        outState.putString("Operator_Sign",Operator);
        outState.putString("Equation",Binding.Equation.getText().toString());
        outState.putString("Input",Binding.Input.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        OpA = savedInstanceState.getFloat("Operand_A");
        OpB = savedInstanceState.getFloat("Operand_B");
        Operator = savedInstanceState.getString("Operator_Sign");
        Binding.Equation.setText(savedInstanceState.getString("Equation"));
        Binding.Input.setText(savedInstanceState.getString("Input"));

    }
}