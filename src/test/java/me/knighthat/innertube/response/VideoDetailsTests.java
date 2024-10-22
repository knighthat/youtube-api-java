package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VideoDetailsTests extends ResponseTest {

// START: Static fields/functions

    @NotNull
    private static final VideoDetails VIDEO_DETAILS =
            GSON.fromJson( getSectionAsString( "videoDetails" ), VideoDetails.class );

// END: Static fields/functions

    @Test
    void getVideoId() {
        Assertions.assertEquals( "BciS5krYL80", VIDEO_DETAILS.getVideoId() );
    }

    @Test
    void getTitle() {
        Assertions.assertEquals( "Hotel California", VIDEO_DETAILS.getTitle() );
    }

    @Test
    void getLengthSeconds() {
        Assertions.assertEquals( "391", VIDEO_DETAILS.getLengthSeconds() );
    }

    @Test
    void getChannelId() {
        Assertions.assertEquals( "UC49r4GNHHpc-eQ9hmD2Rg6A", VIDEO_DETAILS.getChannelId() );
    }

    @Test
    void getThumbnails() {
        Assertions.assertEquals( 5, VIDEO_DETAILS.getThumbnails().size() );
    }
}