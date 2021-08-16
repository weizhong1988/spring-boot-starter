package com.weiz.mapper;

        import com.weiz.pojo.SysUser;

        import java.util.List;

public interface SysUserMapperCustom {
    List<SysUser> queryUserSimplyInfoById(String userId);
    List<SysUser> queryAllUserListCustom();
}