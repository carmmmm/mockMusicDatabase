package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreatePlaylistActivity_Factory implements Factory<CreatePlaylistActivity> {
  private final Provider<PlaylistDao> playlistDaoProvider;

  public CreatePlaylistActivity_Factory(Provider<PlaylistDao> playlistDaoProvider) {
    this.playlistDaoProvider = playlistDaoProvider;
  }

  @Override
  public CreatePlaylistActivity get() {
    return new CreatePlaylistActivity(playlistDaoProvider.get());
  }

  public static CreatePlaylistActivity_Factory create(Provider<PlaylistDao> playlistDaoProvider) {
    return new CreatePlaylistActivity_Factory(playlistDaoProvider);
  }
}
