package net.xdclass.controller;

import net.xdclass.domain.Video;
import net.xdclass.domain.VideoOrder;
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

    @Autowired
    private RestTemplate restTemplate;

    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "save")
    public Object save(String videoID) {
        List<ServiceInstance> instances = discoveryClient.getInstances("xdclass-video-service");
        ServiceInstance serviceInstance = instances.get(0);
        Video video = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/api/v1/video/find_by_id?videoId=" + videoID, Video.class);
        VideoOrder videoOrder = new VideoOrder();
        videoOrder.setVideoId(video.getId());
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setCreateTime(video.getCreateTime());

        return videoOrder;
    }

}
