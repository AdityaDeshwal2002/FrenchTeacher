package com.example.frenchteacher;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MaterialButton blackButton,redButton,greenButton,purpleButton,yellowButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        blackButton = findViewById(R.id.blackButton);
        redButton = findViewById(R.id.redButton);
        greenButton = findViewById(R.id.greenButton);
        purpleButton = findViewById(R.id.purpleButton);
        yellowButton = findViewById(R.id.yellowButton);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        blackButton.setOnClickListener(this::onClick);
        redButton.setOnClickListener(this::onClick);
        greenButton.setOnClickListener(this::onClick);
        purpleButton.setOnClickListener(this::onClick);
        yellowButton.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        int idInt = v.getId();
        if (idInt == R.id.blackButton){
           playSounds(R.raw.black);
        } else if (idInt == R.id.redButton) {
            playSounds(R.raw.red);
        } else if (idInt == R.id.greenButton) {
            playSounds(R.raw.green);
        } else if (idInt == R.id.purpleButton) {
            playSounds(R.raw.purple);
        } else if (idInt == R.id.yellowButton) {
            playSounds(R.raw.yellow);
        }
        else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }

    public void playSounds(int song){
        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,song);
        mediaPlayer.start();
    }
}