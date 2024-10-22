package me.knighthat.innertube.endpoint;

import com.google.gson.Gson;
import me.knighthat.innertube.Constants;
import me.knighthat.innertube.body.PlayerRequestBody;
import me.knighthat.innertube.response.SongResponse;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class YTMusic {

// START: Static fields/functions

    @NotNull
    private static final Gson      GSON            = new Gson();
    @NotNull
    private static final MediaType JSON            = MediaType.get( "application/json; charset=utf-8" );
    @NotNull
    public static        String    BASE_URL        = "https://music.youtube.com";
    @NotNull
    public static        String    PLAYER_ENDPOINT = "/youtubei/v1/player";
    @NotNull
    public static        String    HOST            = "music.youtube.com";

// END: Static fields/functions

    @NotNull
    private final OkHttpClient client;

    public YTMusic() {
        this.client = new OkHttpClient();
    }

    private @Nullable String sendRequest(
            @NotNull String endpoint,
            @NotNull Map<String, String> headers,
            @NotNull RequestBody body
    ) {
        Request.Builder builder = new Request.Builder().url( BASE_URL + endpoint );
        for ( Map.Entry<String, String> entry : headers.entrySet() )
            builder = builder.header( entry.getKey(), entry.getValue() );
        Request request = builder.post( body ).build();

        try ( Response response = client.newCall( request ).execute() ) {
            if ( !response.isSuccessful() ) {
                System.out.println( "Request failed with code: " + response.code() );
                System.out.println( response.body().string() );
            } else if ( response.body() != null ) {
                System.out.println( "Request sent successfully: " + response.code() );
                return response.body().string();
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        }

        return null;
    }

    public @NotNull Optional<SongResponse> getSong( @NotNull String videoId ) {
        Map<String, String> headers = new HashMap<>();
        headers.put( "Host", YTMusic.HOST );
        headers.put( "Content-Type", Constants.CONTENT_TYPE );
        headers.put( "User-Agent", Constants.USER_AGENT );
        headers.put( "Accept", "*/*" );
        headers.put( "Origin", YTMusic.BASE_URL );
        headers.put( "Accept-Encoding", String.join( ", ", Constants.SUPPORTED_ENCODINGS ) );
        headers.put( "Accept-Language", String.join( ", ", Constants.SUPPORTED_LANGUAGES ) );

        PlayerRequestBody playerRequestBody = new PlayerRequestBody( videoId );
        RequestBody body = RequestBody.create( playerRequestBody.toJson(), JSON );

        String responseStr = sendRequest( PLAYER_ENDPOINT, headers, body );
        if ( responseStr == null )
            return Optional.empty();

        System.out.println( responseStr );
        SongResponse song = GSON.fromJson( responseStr, SongResponse.class );
        return Optional.of( song );
    }
}
