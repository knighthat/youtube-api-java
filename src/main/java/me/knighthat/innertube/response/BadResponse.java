package me.knighthat.innertube.response;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class BadResponse implements Response {

    @NotNull
    private final Error error;

    public int getCode() { return error.code; }

    public @NotNull String getMessage() { return error.message; }

    public @NotNull String getStatus() { return error.status; }

    @AllArgsConstructor
    static class Error {
        private final int    code;
        @NotNull
        private final String message;
        @NotNull
        private final String status;
    }
}
