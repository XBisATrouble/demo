package com.cqupt.controller;

import com.cqupt.domain.QualityEntity;
import com.cqupt.domain.StationEntity;
import com.cqupt.domain.result.ExceptionMsg;
import com.cqupt.domain.result.ResponseData;
import com.cqupt.mapper.QualityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class QualityController {
    @Autowired
    private QualityMapper qualityMapper;

    @RequestMapping(value = "/quality/{id}",method = RequestMethod.GET)
    public ResponseData show(@PathVariable int id) {
        QualityEntity quality =  qualityMapper.getOne(id);
        if (quality == null) {
            return new ResponseData(ExceptionMsg.NOTFOUNDUSER);
        }
        return new ResponseData(ExceptionMsg.SUCCESS,quality);
    }

    @RequestMapping(value = "/quality",method = RequestMethod.POST)
    public ResponseData store(@ModelAttribute QualityEntity quality) {
        qualityMapper.insert(quality);
        return new ResponseData(ExceptionMsg.SUCCESS,quality);
    }
}
