package me.knighthat.innertube.response;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class SongResponse extends ServerResponse {

    @NotNull
    private final StreamingData streamingData;
    @NotNull
    private final VideoDetails  videoDetails;
    @NotNull
    private final PlayerConfig  playerConfig;

    public SongResponse(
            @NotNull ResponseContext responseContext,
            @NotNull PlayabilityStatus playabilityStatus,
            @NotNull StreamingData streamingData,
            @NotNull VideoDetails videoDetails,
            @NotNull PlayerConfig playerConfig
    ) {
        super( responseContext, playabilityStatus );
        this.streamingData = streamingData;
        this.videoDetails = videoDetails;
        this.playerConfig = playerConfig;
    }
}
