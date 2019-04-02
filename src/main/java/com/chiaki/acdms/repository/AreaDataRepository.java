package com.chiaki.acdms.repository;

import com.chiaki.acdms.entity.Area;
import com.chiaki.acdms.entity.AreaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaDataRepository extends JpaRepository<AreaData,String> {
    List<AreaData> findByAreaName(String areaname);
    AreaData findFirst1ByAid(Long areaId);
}
