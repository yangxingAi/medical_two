package com.cqupt.software_1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
public interface DataMapper {
    List<Map<String, Object>> selectListById(@Param("satisfiedSamples") Set<Integer> satisfiedSamples, @Param("tableName") String tableName);
}
