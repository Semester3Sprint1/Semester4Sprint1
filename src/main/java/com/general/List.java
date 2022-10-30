package com.general;

import com.tournament.Tournament;

import java.util.ArrayList;

public class List<T> {
    private ArrayList<T> list = new ArrayList<>();


    public ArrayList<T> getList() {
        return list;
    }

    public void add(T item){
        list.add(item);
    }

    public void remove(T item){
        list.remove(item);
    }

    public  <T extends Tournament> Object findTournament(String name, ArrayList<T> list){

      var object = list.stream()
                .filter(m-> m.getName().toUpperCase().equals(name.toUpperCase())).findAny().orElse(null);
        return  object;
    }

}
