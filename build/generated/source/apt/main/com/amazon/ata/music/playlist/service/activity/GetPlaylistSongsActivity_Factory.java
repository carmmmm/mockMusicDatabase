package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetPlaylistSongsActivity_Factory implements Factory<GetPlaylistSongsActivity> {
  private final Provider<PlaylistDao> playlistDaoProvider;

  public GetPlaylistSongsActivity_Factory(Provider<PlaylistDao> playlistDaoProvider) {
    this.playlistDaoProvider = playlistDaoProvider;
  }

  @Override
  public GetPlaylistSongsActivity get() {
    return new GetPlaylistSongsActivity(playlistDaoProvider.get());
  }

  public static GetPlaylistSongsActivity_Factory create(Provider<PlaylistDao> playlistDaoProvider) {
    return new GetPlaylistSongsActivity_Factory(playlistDaoProvider);
  }
}
