package com.amazon.ata.music.playlist.service.activity;

import com.amazon.ata.music.playlist.service.converters.ModelConverter;
import com.amazon.ata.music.playlist.service.dynamodb.models.AlbumTrack;
import com.amazon.ata.music.playlist.service.dynamodb.models.Playlist;
import com.amazon.ata.music.playlist.service.models.requests.AddSongToPlaylistRequest;
import com.amazon.ata.music.playlist.service.models.results.AddSongToPlaylistResult;
import com.amazon.ata.music.playlist.service.models.SongModel;
import com.amazon.ata.music.playlist.service.dynamodb.AlbumTrackDao;
import com.amazon.ata.music.playlist.service.dynamodb.PlaylistDao;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dagger.Provides;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apiguardian.api.API;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the AddSongToPlaylistActivity for the MusicPlaylistService's AddSongToPlaylist API.
 *
 * This API allows the customer to add a song to their existing playlist.
 */
public class AddSongToPlaylistActivity implements RequestHandler<AddSongToPlaylistRequest, AddSongToPlaylistResult> {
    private final Logger log = LogManager.getLogger();
    private final PlaylistDao playlistDao;
    private final AlbumTrackDao albumTrackDao;

    /**
     * Instantiates a new AddSongToPlaylistActivity object.
     *
     * @param playlistDao PlaylistDao to access the playlist table.
     * @param albumTrackDao AlbumTrackDao to access the album_track table.
     */
    @Inject
    public AddSongToPlaylistActivity(PlaylistDao playlistDao, AlbumTrackDao albumTrackDao) {
        this.playlistDao = playlistDao;
        this.albumTrackDao = albumTrackDao;
    }

    /**
     * This method handles the incoming request by adding an additional song
     * to a playlist and persisting the updated playlist.
     * <p>
     * It then returns the updated song list of the playlist.
     * <p>
     * If the playlist does not exist, this should throw a PlaylistNotFoundException.
     * <p>
     * If the album track does not exist, this should throw an AlbumTrackNotFoundException.
     *
     * @param addSongToPlaylistRequest request object containing the playlist ID and an asin and track number
     *                                 to retrieve the song data
     * @return addSongToPlaylistResult result object containing the playlist's updated list of
     *                                 API defined {@link SongModel}s
     */
    //Once done, we can implement AddSongToPlaylistActivity's  handleRequest method to fetch the album
    // information and add it to the Playlist's songList, save the updated Playlist and return the updated
    // song list from the API. Update the Activity to use the ModelConverter to convert the AlbumTrack's to
    // SongModel's as needed. Make the change, and then uncomment and run the AddSongToPlaylistActivityTest
    // unit tests.
    @Override
    public AddSongToPlaylistResult handleRequest(final AddSongToPlaylistRequest addSongToPlaylistRequest, Context context) {
        log.info("Received AddSongToPlaylistRequest {} ", addSongToPlaylistRequest);

        Playlist playlist = playlistDao.getPlaylist(addSongToPlaylistRequest.getId());
        AlbumTrack albumTrack = albumTrackDao.getAlbumTrack(addSongToPlaylistRequest.getAsin(), addSongToPlaylistRequest.getTrackNumber());
        List<AlbumTrack> albumTrackList = playlist.getSongList();
        if (addSongToPlaylistRequest.isQueueNext()) {
            albumTrackList.add(0, albumTrack);
        } else {
            albumTrackList.add(albumTrack);
        }
        playlist.setSongList(albumTrackList);
        playlistDao.savePlaylist(playlist);
        List<SongModel> songModelList = new ArrayList<>();
        for (AlbumTrack albumTrack1 : albumTrackList) {
            SongModel songModel = SongModel.builder()
                    .withAsin(albumTrack1.getAsin())
                    .withTrackNumber(albumTrack1.getTrackNumber())
                    .withTitle(albumTrack1.getSongTitle())
                    .withAlbum(albumTrack1.getAlbumName())
                    .build();
            songModelList.add(songModel);
        }

        return AddSongToPlaylistResult.builder()
                .withSongList(songModelList)
                .build();
    }
}
