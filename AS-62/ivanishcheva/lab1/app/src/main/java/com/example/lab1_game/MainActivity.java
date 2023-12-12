package com.example.lab1_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public	Integer[] imagesIds = { R.drawable.npc_dota_hero_abaddon,R.drawable.npc_dota_hero_alchemist,R.drawable.npc_dota_hero_abyssal_underlord,R.drawable.npc_dota_hero_antimage,
            R.drawable.npc_dota_hero_ancient_apparition,R.drawable.npc_dota_hero_arc_warden,R.drawable.npc_dota_hero_armadillo,R.drawable.npc_dota_hero_axe,
            R.drawable.npc_dota_hero_abaddon,R.drawable.npc_dota_hero_alchemist,R.drawable.npc_dota_hero_abyssal_underlord,R.drawable.npc_dota_hero_antimage,
            R.drawable.npc_dota_hero_ancient_apparition,R.drawable.npc_dota_hero_arc_warden,R.drawable.npc_dota_hero_armadillo,R.drawable.npc_dota_hero_axe};

    public	Integer[] cardsIds = { R.id.card1, R.id.card2, R.id.card3, R.id.card4,
            R.id.card5, R.id.card6, R.id.card7, R.id.card8,
            R.id.card9, R.id.card10, R.id.card11, R.id.card12,
            R.id.card13, R.id.card14, R.id.card15, R.id.card16};

    private class Card{
        public CardView view;
        public int id;
        public boolean isCardOpen = false;
        public void OpenCard(){
            view.animate().setDuration(400)
                    .setInterpolator(new AccelerateInterpolator(3f))
                    .scaleX(0)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.setBackgroundResource(imagesIds[id]);
                            view.animate().setDuration(400)
                                    .setInterpolator(new AccelerateInterpolator(3f))
                                    .scaleX(1)
                                    .start();
                        }
                    })
                    .start();
            isCardOpen = true;
        }
        public void CloseCard(){
            view.animate().setDuration(400)
                    .setInterpolator(new AccelerateInterpolator(3f))
                    .scaleX(0)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            view.setBackgroundResource(R.drawable.card_back);
                            view.animate().setDuration(400)
                                    .setInterpolator(new AccelerateInterpolator(3f))
                                    .scaleX(1)
                                    .start();
                        }
                    })
                    .start();
            isCardOpen =false;
        }
    };
    private Card[] cards;
    boolean isSecondCard = false;
    private int firstCardId;
    private int firstImageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateGameArea();
    }

    public void CreateGameArea(){
        Collections.shuffle(Arrays.asList(imagesIds));
        cards = new Card[16];
        for(int i = 0; i<16; i++){
            cards[i] = new Card();
            cards[i].view = (CardView) findViewById(cardsIds[i]);
            cards[i].view.setBackgroundResource(R.drawable.card_back);
            cards[i].id = i;
            cards[i].isCardOpen = false;
            int finalI = i;
            cards[i].view.setOnClickListener(v -> {
                if(!cards[finalI].isCardOpen){
                    cards[finalI].OpenCard();
                    if(isSecondCard) {
                        if(imagesIds[finalI] != firstImageId){
                            cards[finalI].CloseCard();
                            cards[firstCardId].CloseCard();
                        }
                        else{
                            cards[finalI].isCardOpen=true;
                            cards[firstCardId].isCardOpen=true;
                        }
                        isSecondCard =false;
                    }
                    else{
                        firstImageId = imagesIds[finalI];
                        firstCardId = finalI;
                        isSecondCard = true;
                    }
                }
            });
        }
    }

    public void GameExit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void GameRestart(View view){
        for(int i = 0; i<16; i++) cards[i].CloseCard();
        isSecondCard = false;
        CreateGameArea();
    }
}