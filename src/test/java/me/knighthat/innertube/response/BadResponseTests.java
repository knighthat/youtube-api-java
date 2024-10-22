package me.knighthat.innertube.response;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

class BadResponseTests {

    // START: Static fields/functions
    @NotNull
    private static final String      FILE_PATH = "error.json";
    @NotNull
    private static final Gson        GSON      = new Gson();
    @NotNull
    private static       BadResponse RESPONSE;

    @BeforeAll
    static void setUp() {
        try (
                InputStream inStream = BadResponseTests.class.getClassLoader().getResourceAsStream( FILE_PATH ) ;
                InputStreamReader streamReader = new InputStreamReader( Objects.requireNonNull( inStream ) )
        ) {
            RESPONSE = GSON.fromJson( streamReader, BadResponse.class );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }

// END: Static fields/functions

    @Test
    void getCode() {
        Assertions.assertEquals( 400, RESPONSE.getCode() );
    }

    @Test
    void getStatus() {
        Assertions.assertEquals( "INVALID_ARGUMENT", RESPONSE.getStatus() );
    }
}