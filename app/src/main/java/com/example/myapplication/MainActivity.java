package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private GameAdapter adapter;
    private List<Game> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemList.add(new Game("ULTRAKILL", "Newblood Studios", "$25", R.drawable.ultrakill_icon, "https://store.steampowered.com/app/1229490/ULTRAKILL/","ULTRAKILL is a fast-paced ultraviolent retro FPS combining the skill-based style scoring from character action games with unadulterated carnage inspired by the best shooters of the '90s. Rip apart your foes with varied destructive weapons and shower in their blood to regain your health"));
        itemList.add(new Game("Terraria", "Re-Logic", "$10", R.drawable.terraria_icon, "https://store.steampowered.com/app/105600/Terraria/","Blending elements of classic action games with the freedom of sandbox-style creativity, Terraria is a unique gaming experience where both the journey and the destination are completely in the player’s control. The Terraria adventure is truly as unique as the players themselves! "));
        itemList.add(new Game("Deep Rock Galactic", "Coffee Stain Publishing", "$30", R.drawable.drg_icon, "https://store.steampowered.com/app/548430/Deep_Rock_Galactic/","Deep Rock Galactic is a 1-4 player co-op FPS featuring badass space Dwarves, 100% destructible environments, procedurally-generated caves, and endless hordes of alien monsters. "));
        itemList.add(new Game("Geometry Dash", "Robtop Games", "$5", R.drawable.gd_icon, "https://store.steampowered.com/app/322170/Geometry_Dash/","Jump and fly your way through danger in this rhythm-based action platformer! "));
        itemList.add(new Game("Marvel Rivals", "NetEase Games", "Free", R.drawable.rivals_icon, "https://store.steampowered.com/app/2767030/Marvel_Rivals/","Marvel Rivals is a Super Hero Team-Based PVP Shooter! Assemble an all-star Marvel squad, devise countless strategies by combining powers to form unique Team-Up skills and fight in destructible, ever-changing battlefields across the continually evolving Marvel universe! "));
        itemList.add(new Game("DUSK", "Newblood Studios", "$20", R.drawable.dusk_icon, "https://store.steampowered.com/app/519860/DUSK/"," Battle through an onslaught of mystical backwater cultists, possessed militants & even darker forces as you attempt to discover just what lurks beneath the Earth in this retro FPS inspired by the '90s legends. "));
        itemList.add(new Game("ELDEN RING", "FromSoftware", "$60", R.drawable.elden_icon, "https://store.steampowered.com/app/1245620/ELDEN_RING/"," THE CRITICALLY ACCLAIMED FANTASY ACTION RPG. Rise, Tarnished, and be guided by grace to brandish the power of the Elden Ring and become an Elden Lord in the Lands Between. "));
        itemList.add(new Game("OMORI", "OMOCAT", "$20", R.drawable.omori_icon, "https://store.steampowered.com/app/1150690/OMORI/"," Explore a strange world full of colorful friends and foes. When the time comes, the path you’ve chosen will determine your fate... and perhaps the fate of others as well. "));
        itemList.add(new Game("Risk of Rain 2", "Gearbox Publishing", "$25", R.drawable.ror2_icon, "https://store.steampowered.com/app/632360/Risk_of_Rain_2/"," Escape a chaotic alien planet by fighting through hordes of frenzied monsters – with your friends, or on your own. Combine loot in surprising ways and master each character until you become the havoc you feared upon your first crash landing. "));
        itemList.add(new Game("Noita", "Nolla Games", "$15", R.drawable.noita_icon, "https://store.steampowered.com/app/881100/Noita/"," Noita is a magical action roguelite set in a world where every pixel is physically simulated. Fight, explore, melt, burn, freeze and evaporate your way through the procedurally generated world using spells you've created yourself. "));


        adapter = new GameAdapter(itemList);
        recycler.setAdapter(adapter);

        recycler.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(MainActivity.this,
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onSingleTapUp(MotionEvent e) {
                            return true;
                        }
                    });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                // Find the ViewHolder at touch position
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    Game game = itemList.get(position);

                    //Handle click event
                    Intent intent = new Intent(MainActivity.this, GameOnclick.class);
                    intent.putExtra("GAME_NAME", game.getName());
                    intent.putExtra("GAME_PUBLISHER", game.getPublisher());
                    intent.putExtra("GAME_PRICE", game.getPrice());
                    intent.putExtra("GAME_ICON", game.getImageId());
                    intent.putExtra("GAME_DESC", game.getDescription());
                    intent.putExtra("GAME_URL", game.getSteamURL());
                    startActivity(intent);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                // Not needed
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                // Not needed
            }
        });
    }
}