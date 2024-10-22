package me.knighthat.innertube.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class PlayerRequestBody implements RequestBody {

    @NotNull
    private final String          videoId;
    @NotNull
    private final Context         context;
    @NotNull
    private final PlaybackContext playbackContext;
    private final boolean         racyCheckOk;
    private final boolean         contentCheckOk;

    public PlayerRequestBody(
            @NotNull String videoId,
            @NotNull Context context,
            @NotNull PlaybackContext playbackContext,
            boolean racyCheckOk,
            boolean contentCheckOk
    ) {
        this.videoId = videoId;
        this.context = context;
        this.playbackContext = playbackContext;
        this.racyCheckOk = racyCheckOk;
        this.contentCheckOk = contentCheckOk;
    }

    public PlayerRequestBody( @NotNull String videoId ) {
        this(
                videoId,
                Context.DEFAULT,
                PlaybackContext.DEFAULT,
                true,
                true
        );
    }
}
