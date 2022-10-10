package com.example.dat367_projekt_11.models;
/*
HAR TAGIT HJÄLP AV https://www.baeldung.com/java-timer-and-timertask
för att förstå timer, timerTask och treads
 */


import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Round{
    List<RoundListener> roundListeners;

    public void example(){
        TimerTask roundTask = new TimerTask() {
            public void run() {
                notifySubscribers();
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L *7L;
        timer.scheduleAtFixedRate(roundTask,delay,period);

        }

    public void notifySubscribers(){
        for(RoundListener roundListsner: roundListeners){
            roundListsner.update();
        }
    }
    public void subscribe(RoundListener listener){
        roundListeners.add(listener);

    }

    }

