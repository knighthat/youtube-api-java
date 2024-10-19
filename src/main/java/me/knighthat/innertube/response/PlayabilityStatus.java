package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

@Data
public class PlayabilityStatus implements Serializable {

    @NotNull
    private Status  status;
    @Nullable
    private String  reason;
    private boolean playableInEmbed;
}
