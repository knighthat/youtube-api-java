package me.knighthat.innertube.response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class ResponseTest {

// START: Static fields/functions

    @NotNull
    protected static final Gson       GSON            = new Gson();
    @NotNull
    protected static final String     VALID_FILE_PATH = "music/Android-valid.json";
    @NotNull
    protected static final JsonObject VALID_FILE;

    static {
        try (
                InputStream inStream = PlayabilityStatusTests.class.getClassLoader().getResourceAsStream( VALID_FILE_PATH ) ;
                InputStreamReader streamReader = new InputStreamReader( Objects.requireNonNull( inStream ) )
        ) {
            VALID_FILE = GSON.fromJson( streamReader, JsonObject.class );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

    protected static @NotNull String getSectionAsString( @NotNull String section ) {
        return GSON.toJson( VALID_FILE.get( section ) );
    }

// END: Static fields/functions
}
