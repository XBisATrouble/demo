package com.cqupt.controller;

import com.cqupt.domain.StationEntity;
import com.cqupt.domain.result.ExceptionMsg;
import com.cqupt.domain.result.ResponseData;
import com.cqupt.helper.Crypt;
import com.cqupt.mapper.StationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AuthController {

    @Autowired
    private StationMapper stationMapper;
    private Crypt crypt = new Crypt();

    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public ResponseData login(StationEntity stationEntity) {
        try {
            StationEntity loginStationEntity = stationMapper.getOne(stationEntity.getId());
            if (loginStationEntity == null){
                return new ResponseData(ExceptionMsg.NOTFOUNDUSER);
            }else if (!crypt.decryptBasedDes(loginStationEntity.getPassword()).equals(stationEntity.getPassword())){
                return new ResponseData(ExceptionMsg.PASSWORDERROR);
            }
            return new ResponseData(ExceptionMsg.SUCCESSLOGIN,loginStationEntity);
        }catch (Exception e){
            return new ResponseData(ExceptionMsg.ERROR,e);
        }
    }

    @RequestMapping(value = "/auth",method = RequestMethod.PUT)
    public ResponseData changePassword(@ModelAttribute StationEntity stationEntity) {
        try {
            StationEntity loginStationEntity = stationMapper.getOne(stationEntity.getId());
            stationEntity.setPassword(crypt.encryptBasedDes(stationEntity.getPassword()));
            stationMapper.updatePassword(stationEntity);
            return new ResponseData(ExceptionMsg.SUCCESSUPDATEPWD,loginStationEntity);
        }catch (Exception e){
            return new ResponseData(ExceptionMsg.ERROR);
        }
    }

    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public String  encryptPwd() {
        String result = crypt.encryptBasedDes("123");

        String result2 = crypt.decryptBasedDes(result);
        return result2;
    }
}