package com.cqupt.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class StationEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String position;
    private Timestamp created_at;
    private Timestamp started_at;

    public StationEntity() {
        super();
    }

    public StationEntity(int id, String name, String position,Timestamp created_at,Timestamp started_at) {
        super();
        this.id = id;
        this.name = name;
        this.position = position;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getStarted_at() {
        return started_at;
    }

    public void setStarted_at(Timestamp started_at) {
        this.started_at = started_at;
    }
}
