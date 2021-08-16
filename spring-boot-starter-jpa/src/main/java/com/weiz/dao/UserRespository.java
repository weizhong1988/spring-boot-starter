package com.weiz.dao;

import com.weiz.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户服务数据接口类
 *
 * @author weiz
 * @since 2018-03-12
 */

@Repository
public interface UserRespository extends JpaRepository<Users, Long> {
    Users findByName(String name);
    Users findByNameAndAccount(String name,String account);
    // sql 语句查询
    @Query(value = "select * from users where nick_name = ?1",nativeQuery = true)
    List<Users> findBySql(String nickName);
}