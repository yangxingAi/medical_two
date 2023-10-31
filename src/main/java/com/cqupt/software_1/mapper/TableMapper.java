package com.cqupt.software_1.mapper;

import com.cqupt.software_1.dto.IDAndNew;
import com.cqupt.software_1.entity.CardioTrain;
import com.cqupt.software_1.entity.RangeSplit;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TableMapper {
    void createTable(@Param("tableName") String tableName , @Param("fieldMap") Map<String, String> fieldMap);

    void saveCSV2MySQL(String remotePath,String OriginalFilename);

    void insertTableInfo(String tableName);

    void splitInsert(String tableName, String name, List<RangeSplit> rangeSplit);

    List<Map<String, Integer>> selectTableInfo(String tableName);

    void insertById(CardioTrain cardioTrain);

    void insertID(String tableName);

    List<IDAndNew> selectIdAndNewFiled(String filedName);

    void insert2NewTableById(@Param("idAndNew") List<IDAndNew> idAndNew, @Param("filedName") String filedName, @Param("tableName") String tableName);

    void suoyin(String tableName);
}
