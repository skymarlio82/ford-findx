
package com.ford.apps.findx.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ford.apps.findx.data.entity.LocationPoint;

@Mapper
public interface LocationPointMapper {

    List<LocationPoint> findTops();
    void insertBatch(@Param("lps") List<LocationPoint> lps);
}