package com.cqupt.mapper;

import com.cqupt.domain.QualityEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface QualityMapper {
    @Select("SELECT id,station_id,sources,sources_type,value,created_at,updated_at FROM quality")
    List<QualityEntity> getAll();

    @Select("SELECT id,station_id,sources,sources_type,value,created_at,updated_at FROM quality where station_id = #{id}")
    QualityEntity getByPK(int id);

    @Select("SELECT id,station_id,sources,sources_type,value,created_at,updated_at FROM quality WHERE id = #{id}")
    QualityEntity getOne(int id);

    @Insert("INSERT INTO quality (station_id,sources,sources_type,value,created_at,updated_at) VALUES(#{station_id}, #{sources},#{sources_type},#{value},now(), now())")
    @Options(useGeneratedKeys=true, keyProperty="id")//添加该行，product中的id将被自动添加
    void insert(QualityEntity quality);

    @Update("UPDATE quality SET sources=#{sources},sources_type=#{sources_type},value=#{value},updated_at=now() WHERE id =#{id}")
    void update(QualityEntity quality);

    @Delete("DELETE FROM quality WHERE id =#{id}")
    void delete(int id);

    @Update("UPDATE quality SET password=#{password} WHERE id =#{id}")
    void updatePassword(QualityEntity quality);
}
