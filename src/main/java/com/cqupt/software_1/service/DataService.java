package com.cqupt.software_1.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DataService  {
    List<Map<String, Object>> selectListById(Set<Integer> satisfiedSamples, String tableName);
}
