package com.chiaki.acdms.interfaceService;

import com.chiaki.acdms.entity.Area;

import java.util.Collection;

public interface AreaInterface {
    public Area saveArea(Area area);
    public Boolean deleteArea(String areaName);
    public Area editArea(Area area);
    public Area findArea(String areaName);
    public Collection<Area> getAllAreas();
}
