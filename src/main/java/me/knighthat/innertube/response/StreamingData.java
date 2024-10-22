package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public class StreamingData {

    @NotNull
    private final String               expiresInSeconds;
    @NotNull
    private final List<AdaptiveFormat> adaptiveFormats;

    @Data
    public static class AdaptiveFormat {
        private final short  itag;
        @NotNull
        private final String url;
        @NotNull
        private final String mimeType;
        private final int    bitrate;
        private final short  width;
        private final short  height;
        private final long   lastModified;
        private final int    contentLength;
        private final int    averageBitrate;
        private final int    approxDurationMs;
    }
}
