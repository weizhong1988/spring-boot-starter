package com.weiz.mapper;

import com.weiz.pojo.SysUser;
import com.weiz.utils.MyMapper;

import java.util.List;

public interface SysUserMapperCustom {
    List<SysUser> queryUserSimplyInfoById(String userId);
}