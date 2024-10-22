package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StreamingDataTests extends ResponseTest {

// START: Static fields/functions

    @NotNull
    private static final StreamingData STREAMING_DATA =
            GSON.fromJson( getSectionAsString( "streamingData" ), StreamingData.class );

// END: Static fields/functions

    @Test
    void getExpiresInSeconds() {
        Assertions.assertEquals( "21540", STREAMING_DATA.getExpiresInSeconds() );
    }

    @Test
    void getAdaptiveFormats() {
        Assertions.assertEquals( 17, STREAMING_DATA.getAdaptiveFormats().size() );
    }
}