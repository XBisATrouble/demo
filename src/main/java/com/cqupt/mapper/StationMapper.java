package com.cqupt.mapper;

import com.cqupt.domain.StationEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StationMapper {
    @Select("SELECT id,name,position,password,created_at,started_at FROM stations")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "position", column = "position"),
            @Result(property = "created_at", column = "created_at"),
            @Result(property = "started_at", column = "started_at")
    })
    List<StationEntity> getAll();

    @Select("SELECT id,name,position,password,created_at,started_at FROM stations WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "position", column = "position"),
            @Result(property = "created_at", column = "created_at"),
            @Result(property = "started_at", column = "started_at")
    })
    StationEntity getOne(int id);


    @Insert("INSERT INTO stations (name,position,password,created_at,started_at) VALUES(#{name}, #{position},#{password},${created_at}, ${started_at})")
    @Options(useGeneratedKeys=true, keyProperty="id")//添加该行，product中的id将被自动添加
    void insert(StationEntity station);

    @Update("UPDATE stations SET name=#{name},position=#{position},started_at=now() WHERE id =#{id}")
    void update(StationEntity station);

    @Delete("DELETE FROM stations WHERE id =#{id}")
    void delete(int id);

    @Update("UPDATE stations SET password=#{password} WHERE id =#{id}")
    void updatePassword(StationEntity station);

    @Select("select *from stations where id = #{id}")
    StationEntity getDetailStation(Integer id);
}
