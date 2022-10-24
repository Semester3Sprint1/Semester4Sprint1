package com.general;

import java.util.ArrayList;
import java.util.Random;

public class ScoreCard {

    private Member member;
    private Tournament tournament;
    ArrayList<Integer> scorecard = new ArrayList<>();

    public static  void autoGenList(){
        new Random().ints(-2,7).limit(18).forEach(System.out::println);
    }
}
