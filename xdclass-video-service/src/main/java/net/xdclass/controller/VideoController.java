package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping(value = "find_by_id")
    public Object findByID(@RequestParam(value = "videoID") String videoID, HttpServletRequest request) {
        Video video = videoService.findById(videoID);
        // 返回服务器ip、端口
        video.setServiceInfo(request.getServerName() + ":" + request.getServerPort());
        return video;
    }

}
