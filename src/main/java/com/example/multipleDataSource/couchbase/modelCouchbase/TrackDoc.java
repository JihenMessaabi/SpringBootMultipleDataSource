package com.example.multipleDataSource.couchbase.modelCouchbase;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Document
@Setter
@Getter
public class TrackDoc {
    /**
     * @Id: Represents the Id of the document and it is not necessary since it is not annotated with @Field
     */

    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    private String name;
    @Field
    private String singer;
    @Field
    private String albumName;


}
