package com.game.beautifullApp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    List<String> mywords,shuffle_words;
    EditText myanswer;
    Button next_value;
    TextView word_shuffled,score_txt,try_txt;
    int myScore=0;
    int index;
    int trying=0;
    Dialog mydialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myanswer=findViewById(R.id.myresponse);
        score_txt=findViewById(R.id.Score);
        try_txt=findViewById(R.id.Try);
        word_shuffled=findViewById(R.id.shuffled_word);
        next_value=findViewById(R.id.next_words);
        mydialog=new Dialog(this);

      // Function contains words:
        myword();


    }

    private void myword() {
        mywords = new ArrayList<>();
        shuffle_words = new ArrayList<>();
        mywords.add("animal");
        mywords.add("auto");
        mywords.add("anecdote");
        mywords.add("alphabet");
        mywords.add("ala");
        mywords.add("awesome");
        mywords.add("arise");
        mywords.add("balloon");
        mywords.add("basket");
        mywords.add("bench");
        mywords.add("zoology");
        mywords.add("zone");
        mywords.add("zeal");
        Log.d("mywords", String.valueOf(mywords.size()));
        List<Character> mylettre = null;
        for (int i = 0; i < mywords.size(); i++) {
            mylettre = new ArrayList<>(mywords.get(i).length());
            for (char c : mywords.get(i).toCharArray()) {
                mylettre.add(c);
            }
            Collections.shuffle(mylettre);
            StringBuilder builder = new StringBuilder();
            for (char c : mylettre) {
                builder.append(c);
            }
            if (builder.toString().equals(mywords.get(i))) {
                i = i - 1;
            } else {
                shuffle_words.add(i, builder.toString());

            }
        }

        // take random value from shuffle_words
        // initiaization of random class
        Random random_value = new Random();
        // generation of a random index
        index = random_value.nextInt(shuffle_words.size());
        String word_chosen = shuffle_words.get(index);
        word_shuffled.setText(word_chosen);
        next_value.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (trying < mywords.size()) {
                    trying += 1;
                    String response = myanswer.getText().toString().trim();
                    if (response.equals(mywords.get(index))) {
                        myScore += 1;
                    } else {
                        myScore += 0;

                    }
                    index = random_value.nextInt(shuffle_words.size());
                    String word_chosen = shuffle_words.get(index);
                    word_shuffled.setText(word_chosen);
                    myanswer.setText("");
                    Log.d("Score1", String.valueOf(myScore));
                    score_txt.setText(String.valueOf(myScore)+"PT");
                    try_txt.setText(String.valueOf(trying)+"/"+String.valueOf(mywords.size()));

                } else {
                    /*NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification notification = new Notification.Builder(getApplicationContext()).setContentTitle("Game Notification").setContentText("Game OVER").build();
                    notification.flags = Notification.FLAG_AUTO_CANCEL;
                    notificationManager.notify(0, notification);
                    System.out.println(myScore);
                    Log.d("Score", String.valueOf(myScore));*/
                    TextView mytext_score,try_again;
                    mydialog.setContentView(R.layout.custompop);
                     mytext_score=(TextView) mydialog.findViewById(R.id.myScore_Final);
                    mytext_score.setText(String.valueOf(myScore)+"PT");
                    try_again=(TextView)mydialog.findViewById(R.id.try_again);
                    try_again.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mydialog.dismiss();
                            myScore=0;
                            index=0;
                            trying=0;
                            onStart();
                        }
                    });
                    mydialog.show();



                }
            }

        });
    }
}