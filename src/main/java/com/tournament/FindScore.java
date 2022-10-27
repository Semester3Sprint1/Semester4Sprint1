package com.tournament;

import com.members.Member;
import com.tournament.Score;
import com.tournament.Tournament;

import java.util.ArrayList;
public class FindScore {

    public static Score findScore(Member member, Tournament tournament, ArrayList<Score> scoreList ){
        //compares the Member and Tournament class to return the score object to update.
        Score scoreObject = scoreList.stream().filter(m-> m.getTournament().getName().equals(tournament.getName()))
                .filter(m->m.getMember().getMemberID() == member.getMemberID()).findAny().orElse(null);
        return  scoreObject;
    }

    public static Score findScore(Member member, Tournament tournament) {
        ArrayList<Score> scoreList = Score.getScoreList();

        Score scoreObject = scoreList.stream().filter(m-> m.getTournament().getTournamentID() == tournament.getTournamentID())
                .filter(m-> m.getMember().getMemberID() == member.getMemberID()).findAny().orElse(null);

        return  scoreObject;

    }
}
