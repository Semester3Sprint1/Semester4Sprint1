package com.general;

import java.util.Scanner;

public abstract class Console  {

    private Scanner scanner;
   private int min;
    private int max;


    public Console(Scanner scanner){
        setScanner(scanner);

    }

    public Console(Scanner scanner,  int min, int max) {
        setScanner(scanner);
        setMin(min);
        setMax(max);
    }


    public Console(Scanner scanner,  int min) {
        setScanner(scanner);
        setMin(min);

    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Scanner getScanner() {
        return scanner;
    }


    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void nextLine(){
        getScanner().nextLine();
    }

}
