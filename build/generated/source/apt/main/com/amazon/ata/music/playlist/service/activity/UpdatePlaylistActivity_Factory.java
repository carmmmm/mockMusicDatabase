package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdatePlaylistActivity_Factory implements Factory<UpdatePlaylistActivity> {
  private final Provider<PlaylistDao> playlistDaoProvider;

  public UpdatePlaylistActivity_Factory(Provider<PlaylistDao> playlistDaoProvider) {
    this.playlistDaoProvider = playlistDaoProvider;
  }

  @Override
  public UpdatePlaylistActivity get() {
    return new UpdatePlaylistActivity(playlistDaoProvider.get());
  }

  public static UpdatePlaylistActivity_Factory create(Provider<PlaylistDao> playlistDaoProvider) {
    return new UpdatePlaylistActivity_Factory(playlistDaoProvider);
  }
}
