package com.chiaki.acdms.interfaceService;

import com.chiaki.acdms.entity.Probe;

import java.util.Collection;

public interface ProbeInterface {
    public Probe saveProbeData(Probe proData);
    public Boolean deleteProbeData(Long proId);
    public Probe editProbeData(Probe proData);
    public Probe findProbeData(Long proId);
    public Collection<Probe> getAllProbeData();
}
