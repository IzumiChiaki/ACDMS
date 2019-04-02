package com.chiaki.acdms.implementation;

import com.chiaki.acdms.entity.Device;
import com.chiaki.acdms.entity.Probe;
import com.chiaki.acdms.interfaceService.ProbeInterface;
import com.chiaki.acdms.repository.ProbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class ProbeInterfaceImplementation implements ProbeInterface {

    @Autowired
    ProbeRepository probeRepository;

    @Override
    public Probe saveProbeData(Probe proData) {
        return probeRepository.save(proData);
    }

    @Override
    public Boolean deleteProbeData(Long proId){
        Probe temp = probeRepository.findById(proId);
        if(temp!=null){
            probeRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Probe editProbeData(Probe proData){
        return probeRepository.save(proData);
    }

    @Override
    public Probe findProbeData(Long proId) {
        return probeRepository.findById(proId);
    }

    @Override
    public Collection<Probe> getAllProbeData(){
        Iterable<Probe> itr = probeRepository.findAll();
        return (Collection<Probe>)itr;
    }
}
