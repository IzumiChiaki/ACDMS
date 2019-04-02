package com.chiaki.acdms.repository;

import com.chiaki.acdms.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,String> {
    Location findByLocationName(String locationtitle);
}