package com.gojava.model;

import java.util.Random;
import java.util.UUID;

/**
 * Created by root on 24.04.2017.
 */
public class IdGenerator {

    public static long getRandomId(){
        return new Random().nextLong();
    }

    public static UUID getRandomUUID(){
        return UUID.randomUUID();
    }
}
