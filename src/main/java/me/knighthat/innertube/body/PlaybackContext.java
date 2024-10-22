package me.knighthat.innertube.body;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
public class PlaybackContext {

// START: Static fields/functions

    @NotNull
    public static final PlaybackContext DEFAULT;

    static {
        ContentPlaybackContext def = new ContentPlaybackContext( ContentPlaybackContext.generateSignatureTimeStamp() );
        DEFAULT = new PlaybackContext( def );
    }

// END: Static fields/functions

    @NotNull
    private final ContentPlaybackContext contentPlaybackContext;

    @Data
    static class ContentPlaybackContext {

        // START: Static fields/functions
        public static long generateSignatureTimeStamp() {
            return ChronoUnit.DAYS.between( LocalDate.now(), LocalDate.ofEpochDay( 0 ) ) - 1;
        }
        // END: Static fields/functions

        private final long signatureTimeStamp;
    }
}
