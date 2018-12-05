package com.sheepxi.service.impl;

import com.sheepxi.mapper.UserDOMapper;
import com.sheepxi.pojo.dto.UserDO;
import com.sheepxi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 喜🐑
 * @create: 2018-12-05 11:24
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private UserDOMapper userDOMapper;
    public List<UserDO> selectAll() {
        return userDOMapper.listAll();
    }
}
