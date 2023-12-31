package com.cqupt.software_1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cqupt.software_1.entity.UserLog;
import com.cqupt.software_1.mapper.UserLogMapper;

import com.cqupt.software_1.service.UserLogService;
import org.springframework.stereotype.Service;

/**
* @author hp
* @description 针对表【user_log】的数据库操作Service实现
* @createDate 2023-09-15 22:08:18
*/
@Service
public class UserLogServiceImpl extends ServiceImpl<UserLogMapper, UserLog>
    implements UserLogService {

}




