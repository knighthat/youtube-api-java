package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Data
public class VideoDetails implements Serializable {

    @NotNull
    private String videoId;
    @NotNull
    private String title;
    @NotNull
    private String lengthSeconds;
    @NotNull
    private String channelId;
}
