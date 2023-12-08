package com.amazon.ata.music.playlist.service.dynamodb;

import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;

import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.exceptions.InvalidAttributeChangeException;
import com.amazon.ata.music.playlist.service.exceptions.PlaylistNotFoundException;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Component;

import javax.inject.Inject;

/**
 * Accesses data for an album using {@link AlbumTrack} to represent the model in DynamoDB.
 */

public class AlbumTrackDao {
    private final DynamoDBMapper dynamoDbMapper;

    /**
     * Instantiates an AlbumTrackDao object.
     *
     * @param dynamoDbMapper the {@link DynamoDBMapper} used to interact with the album_track table
     */
    @Inject
    public AlbumTrackDao(DynamoDBMapper dynamoDbMapper) {
        this.dynamoDbMapper = dynamoDbMapper;
    }

    public AlbumTrack getAlbumTrack(String asin, Integer trackNumber) {
        AlbumTrack albumTrack = this.dynamoDbMapper.load(AlbumTrack.class, asin, trackNumber);
        if (albumTrack == null) {
            throw new PlaylistNotFoundException("Could not find playlist with asin " + asin);
        }

        if (!(albumTrack.getAsin().equals(asin))) {
            throw new InvalidAttributeChangeException("Could not find playlist with asin" + asin);
        }

        return albumTrack;
    }

}
