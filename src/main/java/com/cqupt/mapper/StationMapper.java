package com.cqupt.mapper;

import com.cqupt.domain.StationEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StationMapper {
    @Select("SELECT * FROM stations")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "position", column = "position"),
            @Result(property = "created_at", column = "created_at"),
            @Result(property = "started_at", column = "started_at")
    })
    List<StationEntity> getAll();

    @Select("SELECT * FROM stations WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "position", column = "position"),
            @Result(property = "created_at", column = "created_at"),
            @Result(property = "started_at", column = "started_at")
    })
    StationEntity getOne(int id);

    @Insert("INSERT INTO stations (name,position,created_at,started_at) VALUES(#{name}, #{position}, #{created_at}, #{started_at})")
    void insert(StationEntity user);

    @Update("UPDATE stations SET name=#{name},position=#{position},created_at=#{created_at},started_at=#{started_at} WHERE id =#{id}")
    void update(StationEntity user);

    @Delete("DELETE FROM stations WHERE id =#{id}")
    void delete(int id);
}
