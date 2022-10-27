package com.tournament;

import com.members.Member;

import java.util.ArrayList;

public class Score {
    public static ArrayList<Score> scoreList = new ArrayList<>();
    private int score;
    private Member member;
    private Tournament tournament;

    public Score(int score, Member member, Tournament tournament) {
        this.score = score;
        this.member = member;
        this.tournament = tournament;
    }


    public int getScore() {
        return score;
    }

    public Member getMember() {
        return member;
    }

    public static ArrayList<Score> getScoreList() {
        return scoreList;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void setScoreList(ArrayList<Score> scoreList) {
        Score.scoreList = scoreList;
    }

    public void addScore(Score score){
        getScoreList().add(score);
    }

    @Override
    public String toString(){
        return(member.getName() +" "+ score);
    }
}
