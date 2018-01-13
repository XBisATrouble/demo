package com.cqupt.controller;

import com.cqupt.entity.StationEntity;
import com.cqupt.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    private StationMapper stationMapper;

    @RequestMapping("/stations")
    public List<StationEntity> index() {
        return stationMapper.getAll();
    }
}