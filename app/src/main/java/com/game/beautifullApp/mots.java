package com.game.beautifullApp;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.HashSet;
import java.util.Set;

public class mots {
    public HashSet<String> mywords=new HashSet<>();
public mots() {


}

    public HashSet<String> getMywords() {
        mywords.add("animal");
        mywords.add("auto");
        mywords.add("anecdote");
        mywords.add("alphabet");
        mywords.add("all");
        mywords.add("awesome");
        mywords.add("arise");
        mywords.add("balloon");
        mywords.add("basket");
        mywords.add("bench");
        mywords.add("zoology");
        mywords.add("zone");
        mywords.add("zeal");
        return mywords;
    }
}
