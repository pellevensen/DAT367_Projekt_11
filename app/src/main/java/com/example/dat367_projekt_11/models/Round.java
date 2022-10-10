package com.example.dat367_projekt_11.models;
/*
HAR TAGIT HJÄLP AV https://www.baeldung.com/java-timer-and-timertask
för att förstå timer, timerTask och treads
 */


import java.util.Timer;
import java.util.TimerTask;

public class Round{

    public void example(){
        TimerTask roundTask = new TimerTask() {
            public void run() {
                System.out.println("Hej");
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L *7L;
        timer.scheduleAtFixedRate(roundTask,delay,period);

        }

    }

