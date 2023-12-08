package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetPlaylistActivity_Factory implements Factory<GetPlaylistActivity> {
  private final Provider<PlaylistDao> playlistDaoProvider;

  public GetPlaylistActivity_Factory(Provider<PlaylistDao> playlistDaoProvider) {
    this.playlistDaoProvider = playlistDaoProvider;
  }

  @Override
  public GetPlaylistActivity get() {
    return new GetPlaylistActivity(playlistDaoProvider.get());
  }

  public static GetPlaylistActivity_Factory create(Provider<PlaylistDao> playlistDaoProvider) {
    return new GetPlaylistActivity_Factory(playlistDaoProvider);
  }
}
