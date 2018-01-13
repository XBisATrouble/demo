package com.cqupt.controller;

import com.cqupt.domain.StationEntity;
import com.cqupt.domain.result.ExceptionMsg;
import com.cqupt.domain.result.ResponseData;
import com.cqupt.helper.Crypt;
import com.cqupt.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StationController {

    @Autowired
    private StationMapper stationMapper;
    private Crypt crypt = new Crypt();

    @RequestMapping(value = "/stations",method = RequestMethod.GET)
    public ResponseData index() {
        List<StationEntity> stations =  stationMapper.getAll();
        if (stations == null){
            return new ResponseData(ExceptionMsg.NOTFOUNDANYUSER,"/api/stations");
        }
        return new ResponseData(ExceptionMsg.SUCCESS,stations);
    }

    @RequestMapping(value = "/station/{id}",method = RequestMethod.GET)
    public ResponseData show(@PathVariable int id) {
        StationEntity station=stationMapper.getOne(id);
        if (station == null){
            return new ResponseData(ExceptionMsg.NOTFOUNDUSER,"/api/stations");
        }
        return new ResponseData(ExceptionMsg.SUCCESS,station);
    }

    @RequestMapping(value = "/station",method = RequestMethod.POST)
    public ResponseData store(@ModelAttribute StationEntity user) {
        try {
            user.setPassword(crypt.encryptBasedDes(user.getPassword()));
            stationMapper.insert(user);
            return new ResponseData(ExceptionMsg.SUCCESSINSERT);
        }catch (Exception e){
            return new ResponseData(ExceptionMsg.DBERROR,e);
        }
    }

    @RequestMapping(value="/station",method = RequestMethod.PUT)
    public ResponseData update(@ModelAttribute StationEntity stationEntity) {
        try {
            stationMapper.update(stationEntity);
            return new ResponseData(ExceptionMsg.SUCCESSUPDATE,stationEntity);
        }catch (Exception e){
            return new ResponseData(ExceptionMsg.DBERROR,e);
        }
    }

    @DeleteMapping(value="/station/{id}")
    public ResponseData destroy(@PathVariable int id) {
        try {
            stationMapper.delete(id);
            return new ResponseData(ExceptionMsg.SUCCESSDELETE);
        }catch (Exception e){
            return new ResponseData(ExceptionMsg.DBERROR,e);
        }
    }
}