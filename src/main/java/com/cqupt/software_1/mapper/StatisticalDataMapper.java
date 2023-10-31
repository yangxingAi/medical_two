package com.cqupt.software_1.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface StatisticalDataMapper {
    List<String> getAllTableNameOfDataBase();

    Long getCount(String tableName);

    Long getColumn(String tableName);

    List<String> getColumnsByTableName(String tableName);

    Long getColumnMissCount(String tableName ,String filedName);

    int countTableBeforeDate(@Param("dateParam") String dateParam);


    Map<String, Object> getStatistical(@Param("filed") String filed,@Param("tableName") String tableName);
}
