package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameOnclick extends AppCompatActivity {
    private String name;
    private String publisher;
    private String price;
    private int imageId;
    private String desc;
    private String steamURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game_onclick);

        Intent intent = getIntent();
        name = intent.getStringExtra("GAME_NAME");
        publisher = intent.getStringExtra("GAME_PUBLISHER");
        price = intent.getStringExtra("GAME_PRICE");
        imageId = intent.getIntExtra("GAME_ICON", 0);
        desc = intent.getStringExtra("GAME_DESC");
        steamURL = intent.getStringExtra("GAME_URL");


        TextView txtName = (TextView) findViewById(R.id.name);
        TextView txtPublisher = (TextView) findViewById(R.id.publisher);
        TextView txtPrice = (TextView) findViewById(R.id.price);
        ImageView imgIcon = (ImageView) findViewById(R.id.gameIcon);
        TextView txtDesc = (TextView) findViewById(R.id.desc);
        Button btnBack = (Button) findViewById(R.id.backbutton);
        Button btnSteam = (Button) findViewById(R.id.steampagebutton);

        txtName.setText(name);
        txtPublisher.setText(publisher);
        txtPrice.setText(price);
        txtDesc.setText(desc);
        if (imageId != 0) {
            imgIcon.setImageResource(imageId);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameOnclick.this, MainActivity.class));
            }
        });

        btnSteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(GameOnclick.this)
                        .setTitle("Open Steam?")
                        .setMessage("Are you sure you want to leave the app and open the Steam page?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String url = steamURL;
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }
}