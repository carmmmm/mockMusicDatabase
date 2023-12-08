package com.amazon.ata.music.playlist.service.lambda;


import com.amazon.ata.music.playlist.service.dependency.DaggerServiceComponent;
import com.amazon.ata.music.playlist.service.dependency.ServiceComponent;
import com.amazon.ata.music.playlist.service.models.requests.AddSongToPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.AddSongToPlaylistResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AddSongToPlaylistActivityProvider implements RequestHandler<AddSongToPlaylistRequest, AddSongToPlaylistResult> {

//    private static App app;
    private static ServiceComponent daggerServiceComponent;

    public AddSongToPlaylistActivityProvider() {

    }

    @Override
    public AddSongToPlaylistResult handleRequest(final AddSongToPlaylistRequest addSongToPlaylistRequest, Context context) {
        return getDaggerServiceComponent().provideAddSongToPlaylistActivity().handleRequest(addSongToPlaylistRequest, context);
    }

    private ServiceComponent getDaggerServiceComponent() {
        if (daggerServiceComponent == null) {
            daggerServiceComponent = DaggerServiceComponent.create();
        }
        return daggerServiceComponent;
    }
//    private App getApp() {
//        if (app == null) {
//            app = new App();
//        }
//
//        return app;
//    }
}
