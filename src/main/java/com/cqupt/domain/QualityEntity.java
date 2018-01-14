package com.cqupt.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class QualityEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String station_id;
    private String sources;
    private String sources_type;
    private String value;
    private Timestamp created_at;
    private Timestamp updated_at;

    public QualityEntity() {
        super();
    }

    public QualityEntity(int id, String station_id, String sources, String sources_type, String value, Timestamp created_at, Timestamp updated_at) {
        super();
        this.id = id;
        this.station_id = station_id;
        this.sources = sources;
        this.sources_type = sources_type;
        this.value = value;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getSources_type() {
        return sources_type;
    }

    public void setSources_type(String sources_type) {
        this.sources_type = sources_type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getupdated_at() {
        return updated_at;
    }

    public void setupdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
