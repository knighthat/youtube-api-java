package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResponseContextTests extends ResponseTest {

// START: Static fields/functions

    @NotNull
    private static final ResponseContext RESPONSE_CONTEXT =
            GSON.fromJson( getSectionAsString( "responseContext" ), ResponseContext.class );

// END: Static fields/functions

    @Test
    void testVisitorData() {
        Assertions.assertEquals( "CgtjUnkzc3pBT0JKTSiTgcq4BjIKCgJVUxIEGgAgYA%3D%3D", RESPONSE_CONTEXT.getVisitorData() );
    }
}