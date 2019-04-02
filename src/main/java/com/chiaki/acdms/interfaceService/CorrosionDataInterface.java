package com.chiaki.acdms.interfaceService;

import com.chiaki.acdms.entity.CorrosionData;

import java.util.Collection;

public interface CorrosionDataInterface {
    public CorrosionData saveCorrosionData(CorrosionData corData);
    public Boolean deleteCorrosionData(Long cId);
    public CorrosionData editCorrosionData(CorrosionData corData);
    public CorrosionData findCorrosionData(Long cId);
    public Collection<CorrosionData> getAllCorrosionData();
}
