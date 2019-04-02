package com.chiaki.acdms.implementation;

import com.chiaki.acdms.entity.CorrosionData;
import com.chiaki.acdms.interfaceService.CorrosionDataInterface;
import com.chiaki.acdms.repository.CorrosionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class CorrosionInterfaceImplementation implements CorrosionDataInterface{

    @Autowired
    CorrosionDataRepository corrosionDataRepository;

    @Override
    public CorrosionData saveCorrosionData(CorrosionData corData) {
        return corrosionDataRepository.save(corData);
    }

    @Override
    public Boolean deleteCorrosionData(Long cId){
        CorrosionData temp = corrosionDataRepository.findByCid(cId);
        if(temp!=null){
            corrosionDataRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public CorrosionData editCorrosionData(CorrosionData corData){
        return corrosionDataRepository.save(corData);
    }

    @Override
    public CorrosionData findCorrosionData(Long cId) {
        return corrosionDataRepository.findByCid(cId);
    }

    @Override
    public Collection<CorrosionData> getAllCorrosionData(){
        Iterable<CorrosionData> itr = corrosionDataRepository.findAll();
        return (Collection<CorrosionData>)itr;
    }
}
