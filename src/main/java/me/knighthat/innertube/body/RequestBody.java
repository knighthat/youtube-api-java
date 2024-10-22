package me.knighthat.innertube.body;

import me.knighthat.innertube.util.JsonMapping;
import org.jetbrains.annotations.NotNull;

public interface RequestBody extends JsonMapping {

    @NotNull Context getContext();

    @NotNull PlaybackContext getPlaybackContext();

    @Override
    default @NotNull String toJson() { return GSON.toJson( this ); }
}
