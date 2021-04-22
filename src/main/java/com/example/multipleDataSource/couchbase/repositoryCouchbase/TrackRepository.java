package com.example.multipleDataSource.couchbase.repositoryCouchbase;

import com.example.multipleDataSource.couchbase.modelCouchbase.TrackDoc;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface TrackRepository extends CrudRepository<TrackDoc, String> {
    List<TrackDoc> findAllByAlbumName(String albumName);

    /**
     * N1QL query
     * @return
     */
    @Query("SELECT COUNT(s) AS c FROM sample s WHERE s.type = 'com.example.multipleDataSource.couchbase.modelCouchbase.TrackDoc'")
    int countAll();

    @Query("DELETE FROM sample s WHERE s.type = 'com.example.multipleDataSource.couchbase.modelCouchbase.TrackDoc'")
    List<TrackDoc> deleteAllTracks();
}
