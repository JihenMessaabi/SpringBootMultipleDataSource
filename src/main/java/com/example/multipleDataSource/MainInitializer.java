package com.example.multipleDataSource;

import com.example.multipleDataSource.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainInitializer implements CommandLineRunner {

    @Autowired
    private TrackService trackService;



    @Override
    public void run(String... args) throws Exception {
        trackService.create();
        trackService.findAllByALbumName("One night in Japan");
        trackService.findAllByALbumName("this is it.");
     //   trackService.deleteAll();
    }
}
