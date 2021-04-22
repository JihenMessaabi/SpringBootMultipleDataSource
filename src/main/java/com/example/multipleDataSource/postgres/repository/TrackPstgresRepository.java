package com.example.multipleDataSource.postgres.repository;

import com.example.multipleDataSource.postgres.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackPstgresRepository extends JpaRepository<Track, Long>, JpaSpecificationExecutor<Track> {
}
