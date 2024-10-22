package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class PlayerConfig {

    @NotNull
    private final AudioConfig audioConfig;

    @Data
    public static class AudioConfig {

        private final float loudnessDb;
        private final float perceptualLoudnessDb;
    }
}
