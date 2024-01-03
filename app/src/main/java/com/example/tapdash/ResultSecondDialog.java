package com.example.tapdash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ResultSecondDialog extends Dialog {
    private final String message;
    private final SecondActivity secondActivity;
    public ResultSecondDialog(@NonNull Context context, String message, SecondActivity secondActivity) {
        super(context);
        this.message = message;
        this.secondActivity = secondActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_second_dialog);
        TextView messageText = findViewById(R.id.messageText);
        Button startAgainButton = findViewById(R.id.startAgainButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button exitButton = findViewById(R.id.exitButton);

        messageText.setText(message);

        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondActivity.restartMatch();
                dismiss();
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity, LandingPage.class);
                secondActivity.startActivity(intent);
                dismiss();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity, FinalPage.class);
                secondActivity.startActivity(intent);
                dismiss();
            }
        });
    }
}