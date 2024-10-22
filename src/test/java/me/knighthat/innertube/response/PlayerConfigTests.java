package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerConfigTests extends ResponseTest {

// START: Static fields/functions

    @NotNull
    private static final PlayerConfig PLAYER_CONFIG =
            GSON.fromJson( getSectionAsString( "playerConfig" ), PlayerConfig.class );

// END: Static fields/functions

    @Test
    void getLoudnessDb() {
        Assertions.assertEquals( -5.41, PLAYER_CONFIG.getAudioConfig().getLoudnessDb(), .01f );
    }

    @Test
    void getPerceptualLoudnessDb() {
        Assertions.assertEquals( -12.41, PLAYER_CONFIG.getAudioConfig().getPerceptualLoudnessDb(), .01f );
    }
}