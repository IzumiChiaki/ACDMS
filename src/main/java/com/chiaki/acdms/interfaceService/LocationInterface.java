package com.chiaki.acdms.interfaceService;

import com.chiaki.acdms.entity.Location;

import java.util.Collection;

public interface LocationInterface {
    public Location saveLocation(Location loc);
    public Boolean deleteLocation(String locName);
    public Location editLocation(Location loc);
    public Location findLocation(String locName);
    public Collection<Location> getAllLocations();
}