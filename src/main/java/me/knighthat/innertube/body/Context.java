package me.knighthat.innertube.body;

import lombok.Data;
import me.knighthat.innertube.client.WebMusic;
import org.jetbrains.annotations.NotNull;

@Data
public class Context {

    // START: Static fields/functions
    @NotNull
    public static final Context DEFAULT;

    static {
        Client client = new Client(
                "en",
                "US",
                WebMusic.CLIENT_NAME,
                WebMusic.CLIENT_VERSION,
                "WATCH",
                21
        );
        DEFAULT = new Context( client, new ThirdParty() );
    }
// END: Static fields/functions

    @NotNull
    private final Client client;

    @NotNull
    private final ThirdParty thirdParty;

    @Data
    static class Client {

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
        public final int    androidSdkVersion;

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

    @Data
    static class ThirdParty {

        @NotNull
        public final String embedUrl;

        public ThirdParty( @NotNull String embedUrl ) { this.embedUrl = embedUrl; }

        public ThirdParty() { this( "https://www.youtube.com" ); }
    }
}
