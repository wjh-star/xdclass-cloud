package net.xdclass.controller;

import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "find_by_id")
    public Object findByID(String videoID) {
        return videoService.findById(videoID);
    }

}
