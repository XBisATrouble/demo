package com.cqupt.controller;

import com.cqupt.domain.StationEntity;
import com.cqupt.domain.result.ExceptionMsg;
import com.cqupt.domain.result.Response;
import com.cqupt.domain.result.ResponseData;
import com.cqupt.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StationController {

    @Autowired
    private StationMapper stationMapper;

    @RequestMapping("/stations")
    public ResponseData index() {
        List<StationEntity> stations =  stationMapper.getAll();
        return new ResponseData(ExceptionMsg.SUCCESS,stations);
        //return stations;
    }

    @RequestMapping("/station/{id}")
    public StationEntity show(@PathVariable int id) {
        StationEntity user=stationMapper.getOne(id);
        return user;
    }

    @PostMapping(value = "/station")
    public void save(@ModelAttribute StationEntity user) {
        stationMapper.insert(user);
    }

    @PutMapping(value="/station")
    public void update(StationEntity user) {
        stationMapper.update(user);
    }

    @DeleteMapping(value="/station/{id}")
    public void delete(@PathVariable int id) {
        stationMapper.delete(id);
    }
}