package com.cqupt.software_1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqupt.software_1.dto.FeatureCreateDTO;
import com.cqupt.software_1.dto.IDAndNew;
import com.cqupt.software_1.entity.CardioTrain;
import com.cqupt.software_1.entity.RangeSplit;
import com.cqupt.software_1.mapper.TableMapper;
import com.cqupt.software_1.service.CardioTrainService;
import com.cqupt.software_1.mapper.CardioTrainMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
* @author hp
* @description 针对表【cardio_train】的数据库操作Service实现
* @createDate 2023-05-16 16:16:01
*/
@Slf4j
@Service
public class CardioTrainServiceImpl extends ServiceImpl<CardioTrainMapper, CardioTrain>
    implements CardioTrainService{



    @Autowired
    private TableMapper tableMapper;

    @Autowired
    private CardioTrainMapper cardioTrainMapper;

    @Override
    public List<CardioTrain> getAll() {


        List<CardioTrain> cardioTrains = cardioTrainMapper.selectList(null);

        return cardioTrains;
    }

    @Override
    public List<Map<String, Integer>> splitFiled(List<FeatureCreateDTO> featureCreateDTO) {




        return null;
    }

    private String createTable(List<FeatureCreateDTO> featureCreateDTO) {
        // 字段有几个需要划分


        int num = featureCreateDTO.size();

        // 保存结果

        List<Map<String, Integer>> res = new ArrayList<>();


        // 创建一个新表  只要我们需要的字段

        Map<String,String> map  = new HashMap<>();


        for (FeatureCreateDTO createDTO : featureCreateDTO) {
            String name = createDTO.getName();
            map.put("id","int");
            map.put(name,"int");
        }


        String tableName = "new_table_" ;
        tableMapper.createTable(tableName,map);

        tableMapper.insertID(tableName);


        tableMapper.suoyin(tableName);


        return tableName;
    }


}




