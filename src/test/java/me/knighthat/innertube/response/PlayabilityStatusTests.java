package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayabilityStatusTests extends ResponseTest {

// START: Static fields/functions

    @NotNull
    private static final PlayabilityStatus PLAYABILITY_STATUS =
            GSON.fromJson( getSectionAsString( "playabilityStatus" ), PlayabilityStatus.class );

// END: Static fields/functions

    @Test
    void getStatus() {
        Assertions.assertEquals( Status.OK, PLAYABILITY_STATUS.getStatus() );
    }

    @Test
    void getReason() {
        Assertions.assertNull( PLAYABILITY_STATUS.getReason() );
    }
}