package com.chiaki.acdms.repository;


import com.chiaki.acdms.entity.Location;
import com.chiaki.acdms.entity.LocationData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LocationDataRepository extends JpaRepository<LocationData,String> {
    List<LocationData> findByLocationName(String locationname);
    LocationData findFirst1ByLid (Long locId);
}
