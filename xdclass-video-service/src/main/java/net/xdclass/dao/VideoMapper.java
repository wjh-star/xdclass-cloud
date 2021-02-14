package net.xdclass.dao;

import net.xdclass.domain.Video;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface VideoMapper {

    @Select(value = "select * from video where id=#{videoId}")
    Video findById(@Param(value = "videoId") String videoID);

}
