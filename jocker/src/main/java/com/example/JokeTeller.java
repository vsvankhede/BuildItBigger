package com.example;

import java.util.Random;

public class JokeTeller {
    String[] jokes = {
        "I changed my password to incorrect. So whenever I forget what it is the computer will say Your password is incorrect.",
            "A clean house is the sign of a broken computer.",
            "Entered what I ate today into my new fitness app and it just sent an ambulance to my house."
    };

    public String fetchJoke() {
        Random rm = new Random();
        return jokes[rm.nextInt(jokes.length)];
    }
}
