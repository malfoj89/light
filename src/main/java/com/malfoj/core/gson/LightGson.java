package com.malfoj.core.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.time.Instant;
import java.util.function.Supplier;

public class LightGson implements Supplier<Gson> {

    @Override
    public Gson get() {
        return new GsonBuilder()
                .registerTypeAdapter(new TypeToken<Instant>() {}.getType(), new InstantConverter())
                .create();
    }
}
