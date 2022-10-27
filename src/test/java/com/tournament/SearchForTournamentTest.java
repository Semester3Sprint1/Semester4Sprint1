package com.tournament;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
public class SearchForTournamentTest {
     @Test
    public void findTournamentTestObjectReturn(){
        SearchForTournament mockSearch = Mockito.mock(SearchForTournament.class);
        ArrayList<Tournament> tList = new ArrayList<>();
       Tournament tournament = new Tournament( 1,"Mike Open", new Date("03/23/2022"), new Date(), "The House",500);
        Tournament tournament1 = new Tournament( 2,"Alex Open", new Date("03/23/2022"), new Date(), "The Alex House",1500);
       tList.add(tournament);
       tList.add(tournament1);

//       when(SearchForTournament.findTournament("Mike Open", mockList)).thenReturn(tournament);
      // tests Tournament Name version of the find tournament method
       Tournament tournamentFound = SearchForTournament.findTournament("Mike Open", tList);
       Assertions.assertEquals(tournament.getName(), tournamentFound.getName());
       Assertions.assertFalse(tournamentFound.getName().contains("Alex Open"));
       SearchForTournament.tList.add(tournament);
       SearchForTournament.tList.add(tournament1);
       // test the return tournament by id
        tournament.setName("PG Open");
        tournamentFound = SearchForTournament.findTournament(1);
        Assertions.assertEquals(tournament.getName(), tournamentFound.getName());
        Assertions.assertTrue(tournamentFound.getName().contains("PG Open"));
        Assertions.assertFalse(tournamentFound.getName().contains("Mike Open"));
    }
    @Test
    public void findTournamentTestNullReturn(){
         // if the object does not exist in the list it returns null
         ArrayList<Tournament> tList = new ArrayList<>();
        Tournament tournament = new Tournament( 1,"Mike Open", new Date("03/23/2022"), new Date(), "The House",500);
        tList.add(tournament);
        Tournament tournamentFound = SearchForTournament.findTournament("Alex Open", tList);
        Assertions.assertNull(tournamentFound);
    }
}
