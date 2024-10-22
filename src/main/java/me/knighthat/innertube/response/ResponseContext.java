package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ResponseContext {

    @NotNull
    private final String visitorData;
}
