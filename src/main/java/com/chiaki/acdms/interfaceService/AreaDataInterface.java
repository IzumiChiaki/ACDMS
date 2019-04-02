package com.chiaki.acdms.interfaceService;

import com.chiaki.acdms.entity.AreaData;

import java.util.Collection;

public interface AreaDataInterface {
    public AreaData saveAreaData(AreaData areacData);
    public Boolean deleteAreaData(Long areaId);
    public AreaData editAreaData(AreaData areaData);
    public AreaData findAreaData(Long areaId);
    public Collection<AreaData> getAllAreaData();
}
