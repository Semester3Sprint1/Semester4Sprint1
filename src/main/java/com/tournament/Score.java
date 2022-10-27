package com.tournament;

import com.members.Member;

public class Score {
    private int score;
    private Member member;
    private Tournament tournament;

    public Score(int score, Member member, Tournament tournament) {
        this.score = score;
        this.member = member;
        this.tournament = tournament;
    }

    public Score(Member member, Tournament tournament) {
        this.member = member;
        this.tournament = tournament;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return getMember().getName() + "      " + getScore();
    }
}
