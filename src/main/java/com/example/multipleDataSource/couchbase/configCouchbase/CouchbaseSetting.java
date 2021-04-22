package com.example.multipleDataSource.couchbase.configCouchbase;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Couchbase settings loaded from Property file
 */

@Component
@ConfigurationProperties(prefix = "couchbase")
@Getter
@Setter
public class CouchbaseSetting {

	protected static final Logger logger = LoggerFactory.getLogger(CouchbaseSetting.class);

	private String hostName;
	private String bucketName;
	private String password;
	private String username;

	public CouchbaseSetting() {
		logger.info("Loading Couchbase properties");
	}

	@PostConstruct
	public void postConstruct() {
		logger.info("Couchbase properties -> hostName: '{}', bucketName: '{}', password: '{}'", hostName, bucketName,
				password);
	}

}
