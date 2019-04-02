package com.chiaki.acdms.repository;

import com.chiaki.acdms.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area,String>{
    Area findByAreaName(String areatitle);
}
