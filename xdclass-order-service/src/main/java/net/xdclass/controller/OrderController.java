package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
import net.xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/video_order")
public class OrderController {

    // @Autowired
    // private RestTemplate restTemplate;
    //
    // @Autowired
    // private DiscoveryClient discoveryClient;

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "find_by_id")
    public Object findById(String videoID) {
        // List<ServiceInstance> instances = discoveryClient.getInstances("xdclass-video-service");
        // ServiceInstance serviceInstance = instances.get(0);
        // Video video = restTemplate.getForObject("http://xdclass-video-service/api/v1/video/find_by_id?videoId="+ videoID, Video.class);
        Video video = videoService.findById(videoID);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(video.getCreateTime());

        videoOrder.setServiceInfo(video.getServiceInfo());
        return videoOrder;
    }

}
