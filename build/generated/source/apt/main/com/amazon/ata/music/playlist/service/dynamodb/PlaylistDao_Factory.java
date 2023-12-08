package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PlaylistDao_Factory implements Factory<PlaylistDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public PlaylistDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public PlaylistDao get() {
    return new PlaylistDao(dynamoDbMapperProvider.get());
  }

  public static PlaylistDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new PlaylistDao_Factory(dynamoDbMapperProvider);
  }
}
