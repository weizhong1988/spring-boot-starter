package com.weiz.dao;

import com.weiz.pojo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRespository extends JpaRepository<Roles, Long> {
}
