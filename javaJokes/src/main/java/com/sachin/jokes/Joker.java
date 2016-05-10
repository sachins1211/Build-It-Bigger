package com.sachin.jokes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {
private static Joker instance;
    private static final List<String> jokes = new ArrayList<>();

    static {
        jokes.add("Q: Can a kangaroo jump higher than a house?\nA: Of course, a house doesn’t jump at all");
        jokes.add("Q: What happens to a frog's car when it breaks down?\nA: It gets toad away.");
        jokes.add("Q: Why did the cookie cry?\nA: Because his mother was a wafer so long!");
        jokes.add("Q: What did 0 say to 8?\nA: Nice belt!");
        jokes.add("Q: Why did the elephants get kicked out of the public pool?\nA: THEY KEPT DROPPING THEIR TRUNKS!");
        jokes.add("Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water. ");
        jokes.add("Q: What do calendars eat?\nA: Dates!");
        jokes.add("Q: What's it called when you lend money to a bison?\nA: A BUFFA-LOAN!");
        jokes.add("Q: Why wouldn't the shrimp share his treasure?\nA: Because he was a little shellfish.");
        jokes.add("I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your password is incorrect\".");
        jokes.add("Q: What did one ocean say to the other ocean?\nA: Nothing, they just waved.");
        jokes.add("Q: What is faster Hot or cold?\nA: Hot, because you can catch a cold.");
        jokes.add("Q: Why did the scientist install a knocker on his door?\nA: He wanted to win the No-bell prize!");
        jokes.add("Whenever I find the key to success, someone changes the lock.");
        jokes.add("When tempted to fight fire with fire, remember that the Fire Department usually uses water.");
        jokes.add("Q: What's the difference between being in prison and being a corporate employee? \n" +
                "A: In prison you get free health care.");
        jokes.add("Q: Why did Gus drive his pickup truck over the side of the cliff? \n" +
                "A: He wanted to test his new air brakes.");
    }


    public static Joker getInstance() {
        if (instance == null) {
            instance = new Joker();
        }
        return instance;
    }


    public String getRandomJoke() {
        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));
    }
}
