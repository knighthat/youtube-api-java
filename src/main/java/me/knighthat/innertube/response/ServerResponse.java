package me.knighthat.innertube.response;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class ServerResponse implements Response {

    @NotNull
    private final ResponseContext   responseContext;
    @NotNull
    private final PlayabilityStatus playabilityStatus;

    public @NotNull String getVisitorData() { return getResponseContext().getVisitorData(); }

    public @NotNull Status getStatus() { return getPlayabilityStatus().getStatus(); }

    public @NotNull String getReason() {
        if ( getPlayabilityStatus().getReason() == null )
            return "";
        else
            return getPlayabilityStatus().getReason();
    }
}
