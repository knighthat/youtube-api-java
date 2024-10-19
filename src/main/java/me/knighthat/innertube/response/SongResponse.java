package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Data
public class SongResponse implements Serializable {

    @NotNull
    private PlayabilityStatus playabilityStatus;
    @NotNull
    private VideoDetails      videoDetails;
}
