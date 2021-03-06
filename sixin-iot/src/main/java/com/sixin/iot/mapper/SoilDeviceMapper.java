package com.sixin.iot.mapper;

import com.sixin.iot.domain.SoilDevice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public interface SoilDeviceMapper {
//    查询所有设备情况
    public List<SoilDevice> selectall();
//    增加设备
public int add(@Param("did") String did ,@Param("dname") String dname ,@Param("dstatus") int dstatus ,@Param("dv") int dv
        ,@Param("dctime") Date dctime ,@Param("dftime") Date dftime ,@Param("dcname") String dcname ,@Param("dfname") String dfname ,@Param("note") String note);

//    根据dname删除设备记录
    public  int deletebyname(@Param("dname")String dname);
//  根据ID 查询设备情况
    public SoilDevice selectbyid(@Param("did")String did);
//    根据地域名查询
    public  SoilDevice selectbyname(@Param("dname") String dname);
//
    public List<SoilDevice> selectbynote();

    public List<SoilDevice> selectbyds();

}
