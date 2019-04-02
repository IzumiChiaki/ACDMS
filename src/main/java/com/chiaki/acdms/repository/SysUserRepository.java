package com.chiaki.acdms.repository;

import com.chiaki.acdms.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository <SysUser, Long> {
    SysUser findByUsername(String username);
}