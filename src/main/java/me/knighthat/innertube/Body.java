package me.knighthat.innertube;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Body implements Serializable{

    @NotNull
    public final Context context;
    @NotNull
    public final String videoId;
    @NotNull
    public final PlaybackContext playbackContext;
    public final boolean racyCheckOk;
    public final boolean contentCheckOk;

    public Body(
            @NotNull String hl,
            @NotNull String gl,
            @NotNull String clientName,
            @NotNull String clientVersion,
            @NotNull String clientScreen,
            int androidSdkVersion,
            @NotNull String embedUrl,
            @NotNull String videoId,
            long signatureTimeStamp,
            boolean racyCheckOk,
            boolean contentCheckOk
    ) {
        this.context = new Context(
                hl, gl,clientName, clientVersion, clientScreen, androidSdkVersion, embedUrl
        );
        this.videoId = videoId;
        this.playbackContext = new PlaybackContext( signatureTimeStamp );
        this.racyCheckOk = racyCheckOk;
        this.contentCheckOk = contentCheckOk;
    }

    public static class Context implements Serializable {

        @NotNull
        public final Client client;
        @NotNull
        public final ThirdParty thirdParty;

        public Context(
                @NotNull String hl,
                @NotNull String gl,
                @NotNull String clientName,
                @NotNull String clientVersion,
                @NotNull String clientScreen,
                int androidSdkVersion,
                @NotNull String embedUrl
        ) {
            this.client = new Client(
                    hl, gl, clientName, clientVersion, clientScreen, androidSdkVersion
            );
            this.thirdParty = new ThirdParty( embedUrl );
        }

        public static class Client implements Serializable {

            @NotNull
            public final String hl;
            @NotNull
            public final String gl;
            @NotNull
            public final String clientName;
            @NotNull
            public final String clientVersion;
            @NotNull
            public final String clientScreen;
            public final int androidSdkVersion;

            public Client(
                    @NotNull String hl,
                    @NotNull String gl,
                    @NotNull String clientName,
                    @NotNull String clientVersion,
                    @NotNull String clientScreen,
                    int androidSdkVersion
            ) {
                this.hl = hl;
                this.gl = gl;
                this.clientName = clientName;
                this.clientVersion = clientVersion;
                this.clientScreen = clientScreen;
                this.androidSdkVersion = androidSdkVersion;
            }
        }

        public static class ThirdParty implements Serializable {

            @NotNull
            public final String embedUrl;

            public ThirdParty(@NotNull String embedUrl) { this.embedUrl = embedUrl; }
        }
    }

    public static class PlaybackContext implements  Serializable {

        public final ContentPlaybackContext contentPlaybackContext;

        public PlaybackContext(long signatureTimestamp) { this.contentPlaybackContext = new ContentPlaybackContext( signatureTimestamp ); }

        public static class ContentPlaybackContext implements Serializable {

            public final long signatureTimestamp;

            public ContentPlaybackContext(long signatureTimestamp) { this.signatureTimestamp = signatureTimestamp; }
        }
    }
}
