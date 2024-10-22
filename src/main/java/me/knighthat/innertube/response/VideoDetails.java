package me.knighthat.innertube.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
public class VideoDetails {

    @NotNull
    private final String     videoId;
    @NotNull
    private final String     title;
    @NotNull
    private final String     lengthSeconds;
    @NotNull
    private final String     channelId;
    @NotNull
    @Getter(AccessLevel.NONE)
    private final Thumbnails thumbnail;

    public @NotNull List<Thumbnail> getThumbnails() { return thumbnail.thumbnails; }

    @AllArgsConstructor
    public static class Thumbnails {

        @NotNull
        private final List<Thumbnail> thumbnails;
    }

    @Data
    public static class Thumbnail {
        @NotNull
        private final String url;
        private final short  width;
        private final short  height;
    }
}
