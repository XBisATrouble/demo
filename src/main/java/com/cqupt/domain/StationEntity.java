package com.cqupt.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class StationEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String position;
    private String password;
    private String created_at;
    private String started_at;
    private QualityEntity qualityEntity;

    public StationEntity() {
        super();
    }

    public StationEntity(int id, String name, String position,String password,String created_at,String started_at) {
        super();
        this.id = id;
        this.name = name;
        this.position = position;
        this.password = password;
        this.created_at = created_at;
        this.started_at = started_at;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getStarted_at() {
        return started_at;
    }

    public void setStarted_at(String started_at) {
        this.started_at = started_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public QualityEntity getQualityEntity() {
        return qualityEntity;
    }

    public void setQualityEntity(QualityEntity qualityEntity) {
        this.qualityEntity = qualityEntity;
    }
}
