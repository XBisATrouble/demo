package com.cqupt.mapper;

import com.cqupt.entity.StationEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StationMapper {
    @Select("SELECT * FROM stations")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "position", column = "position")
    })
    List<StationEntity> getAll();
}
