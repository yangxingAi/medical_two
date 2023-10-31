package com.cqupt.software_1.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cqupt.software_1.mapper.DataMapper;
import com.cqupt.software_1.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<Map<String, Object>> selectListById(Set<Integer> satisfiedSamples, String tableName) {



        return dataMapper.selectListById(satisfiedSamples,tableName);
    }
}
