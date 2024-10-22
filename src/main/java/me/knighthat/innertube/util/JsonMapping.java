package me.knighthat.innertube.util;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface JsonMapping {

// START: Static fields/functions

    @NotNull
    Gson GSON = new Gson();

// END: Static fields/functions

    @NotNull String toJson();
}
