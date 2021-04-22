package com.example.multipleDataSource.couchbase.repositoryCouchbase;

import com.couchbase.client.java.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.couchbase.config.BeanNames;
import org.springframework.stereotype.Repository;

@Repository
public class TrackCountersRepository {

    private static final long INITIAL_COUNTER_VALUE = 1;
    private static final String TRACK_COUNTER_KEY = "track::counter";

    /**
     *  Add the qualifier in case you have multiple buckets in your configuration otherwise remove it.
     */
    @Autowired
    @Qualifier(BeanNames.COUCHBASE_BUCKET)
    private Bucket bucket;

    public Long counter() {
        return bucket.counter(TRACK_COUNTER_KEY, 1, INITIAL_COUNTER_VALUE).content();
    }

    public void inc() {
        bucket.counter(TRACK_COUNTER_KEY, 1, INITIAL_COUNTER_VALUE);
    }

    public void dec() {
        bucket.counter(TRACK_COUNTER_KEY, -1, INITIAL_COUNTER_VALUE);
    }

    public Long getValue() {
        return bucket.counter(TRACK_COUNTER_KEY, 0).content();
    }


}
