package com.cqupt.controller;

import com.cqupt.domain.QualityEntity;
import com.cqupt.domain.StationEntity;
import com.cqupt.domain.result.ExceptionMsg;
import com.cqupt.domain.result.ResponseData;
import com.cqupt.helper.Crypt;
import com.cqupt.mapper.QualityMapper;
import com.cqupt.mapper.StationMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class StationController {

    @Autowired
    private StationMapper stationMapper;
    @Autowired
    private QualityMapper qualityMapper;
    private Crypt crypt = new Crypt();

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String  hello() {
        return "Welcome123";
    }

    @RequestMapping(value = "/stations",method = RequestMethod.GET)
    public ResponseData index(@RequestParam(value = "limit", defaultValue = "10") int limit, @RequestParam(value = "page", defaultValue = "1") int page) {
        PageHelper.startPage(page,limit);
        List<StationEntity> stations =  stationMapper.getAll();

        if (stations == null){
            return new ResponseData(ExceptionMsg.NOTFOUNDANYUSER,"/api/stations");
        }
        return new ResponseData(ExceptionMsg.SUCCESS,stations);
    }

    @RequestMapping(value = "/station/{id}",method = RequestMethod.GET)
    public ResponseData show(@PathVariable int id) {
        StationEntity station=stationMapper.getDetailStation(id);
        if (station == null){
            return new ResponseData(ExceptionMsg.NOTFOUNDUSER,"/api/stations");
        }
        QualityEntity quality = qualityMapper.getByPK(station.getId());
        station.setQualityEntity(quality);
        return new ResponseData(ExceptionMsg.SUCCESS,station);
    }

    @RequestMapping(value = "/station/{id}/quality",method = RequestMethod.GET)
    public ResponseData getDetailStation(@PathVariable int id) {
        QualityEntity quality = qualityMapper.getByPK(id);
        if (quality == null){
            return new ResponseData(ExceptionMsg.NOTFOUNDUSER);
        }
        return new ResponseData(ExceptionMsg.SUCCESS,quality);
    }

    @RequestMapping(value = "/station",method = RequestMethod.POST)
    public ResponseData store(@ModelAttribute StationEntity user) {
        try {
            if (user.getPassword()==null){
                return new ResponseData(ExceptionMsg.DBERROR);
            }
            user.setPassword(crypt.encryptBasedDes(user.getPassword()));
            stationMapper.insert(user);
            user.setQualityEntity(new QualityEntity(user.getId()));
            qualityMapper.insert(user.getQualityEntity());
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