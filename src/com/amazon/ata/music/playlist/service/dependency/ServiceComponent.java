package com.amazon.ata.music.playlist.service.dependency;

import com.amazon.ata.music.playlist.service.activity.*;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    GetPlaylistSongsActivity provideGetPlaylistSongsActivity();

    AddSongToPlaylistActivity provideAddSongToPlaylistActivity();

    UpdatePlaylistActivity provideUpdatePlaylistActivity();

    GetPlaylistActivity provideGetPlaylistActivity();

    CreatePlaylistActivity provideCreatePlaylistDao();

    AlbumTrackDao provideAlbumTrackDao();
}
