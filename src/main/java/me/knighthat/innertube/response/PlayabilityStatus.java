package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Data
public class PlayabilityStatus {

    @NotNull
    private Status status;
    @Nullable
    private String reason;
}
