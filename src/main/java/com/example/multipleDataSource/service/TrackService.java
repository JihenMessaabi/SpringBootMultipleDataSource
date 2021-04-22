package com.example.multipleDataSource.service;

import com.example.multipleDataSource.couchbase.modelCouchbase.TrackDoc;
import com.example.multipleDataSource.couchbase.repositoryCouchbase.TrackRepository;
import com.example.multipleDataSource.postgres.model.Track;
import com.example.multipleDataSource.postgres.repository.TrackPstgresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class TrackService {

    Logger logger = LoggerFactory.getLogger(TrackService.class);

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private TrackPstgresRepository trackPstgRepository;

    public void create() {
        if (trackRepository.countAll() == 0) {

            logger.info("Creating documents...");

            TrackDoc trackDoc1 = new TrackDoc();
            trackDoc1.setName("They don't care about us.");
            trackDoc1.setAlbumName("this is it.");
            trackDoc1.setSinger("Michael Jackson");

            TrackDoc trackDoc2 = new TrackDoc();
            trackDoc2.setName("Wanna be startin' something.");
            trackDoc2.setAlbumName("this is it.");
            trackDoc2.setSinger("Michael Jackson");

            TrackDoc trackDoc3 = new TrackDoc();
            trackDoc3.setName("Jam.");
            trackDoc3.setAlbumName("this is it.");
            trackDoc3.setSinger("Michael Jackson");

            TrackDoc trackDoc4 = new TrackDoc();
            trackDoc4.setName("Lovely one");
            trackDoc4.setAlbumName("One night in Japan");
            trackDoc4.setSinger("Michael Jackson");

            TrackDoc trackDoc5 = new TrackDoc();
            trackDoc5.setName("Wanna be startin' something");
            trackDoc5.setAlbumName("One night in Japan");
            trackDoc5.setSinger("Michael Jackson");

            trackRepository.saveAll(Arrays.asList(trackDoc1, trackDoc2, trackDoc3, trackDoc4, trackDoc5));

            Arrays.asList(trackDoc1, trackDoc2, trackDoc3, trackDoc4, trackDoc5).forEach(u ->{
                Track track= new Track();
                track.setUuid(UUID.randomUUID().toString());
                track.setName(u.getName());
                track.setSinger(u.getSinger());
                track.setAlbumName(u.getAlbumName());
                trackPstgRepository.save(track);
            });

        } else {
            logger.info("Documents are already created.");
        }
    }



    public List<TrackDoc> findAllByALbumName(String albumName) {
        logger.info(" ***** ALBUM: {} *****", albumName);
        List<TrackDoc> trackDocs = trackRepository.findAllByAlbumName(albumName);
        trackDocs.forEach(t -> logger.info(t.getName()));
        return trackDocs;
    }

    public void deleteAll(){
        logger.info("DELETING ALL : LOADING ... ");
        trackRepository.deleteAllTracks();
        logger.info("All Tracks are deleted.");
    }



}
