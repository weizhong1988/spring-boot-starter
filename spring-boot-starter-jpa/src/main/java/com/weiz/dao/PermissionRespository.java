package com.weiz.dao;

import com.weiz.pojo.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRespository extends JpaRepository<Permissions, Long> {
}
