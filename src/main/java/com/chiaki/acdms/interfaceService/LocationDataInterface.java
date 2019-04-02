package com.chiaki.acdms.interfaceService;

import com.chiaki.acdms.entity.LocationData;
import java.util.Collection;

public interface LocationDataInterface {
    public LocationData saveLocationData(LocationData locData);
    public Boolean deleteLocationData(Long locId);
    public LocationData editLocationData(LocationData locData);
    public LocationData findLocationData(Long locId);
    public Collection<LocationData> getAllLocationData();
}
