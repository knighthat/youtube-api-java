package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;

public interface SuccessfulResponse extends Response {

    @NotNull ResponseContext getResponseContext();

    @NotNull PlayabilityStatus getPlayabilityStatus();

    default @NotNull String getVisitorData() { return getResponseContext().getVisitorData(); }

    default @NotNull Status getStatus() { return getPlayabilityStatus().getStatus(); }

    default @NotNull String getReason() {
        if ( getPlayabilityStatus().getReason() == null )
            return "";
        else
            return getPlayabilityStatus().getReason();
    }
}
