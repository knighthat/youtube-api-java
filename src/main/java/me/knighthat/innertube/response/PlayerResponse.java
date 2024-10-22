package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class PlayerResponse implements GoodResponse {

    @NotNull
    private final ResponseContext   responseContext;
    @NotNull
    private final PlayabilityStatus playabilityStatus;
    @NotNull
    private final StreamingData     streamingData;
    @NotNull
    private final VideoDetails      videoDetails;
    @NotNull
    private final PlayerConfig      playerConfig;
}
