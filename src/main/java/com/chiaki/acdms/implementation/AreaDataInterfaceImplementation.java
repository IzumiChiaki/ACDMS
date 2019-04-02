package com.chiaki.acdms.implementation;

import com.chiaki.acdms.entity.AreaData;
import com.chiaki.acdms.interfaceService.AreaDataInterface;
import com.chiaki.acdms.repository.AreaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class AreaDataInterfaceImplementation implements AreaDataInterface {

    @Autowired
    AreaDataRepository areaDataRepository;

    @Override
    public AreaData saveAreaData(AreaData areaData) {
        return areaDataRepository.save(areaData);
    }

    @Override
    public Boolean deleteAreaData(Long areaId){
        AreaData temp = areaDataRepository.findFirst1ByAid(areaId);
        if(temp!=null){
            areaDataRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public AreaData editAreaData(AreaData areaData){
        return areaDataRepository.save(areaData);
    }

    @Override
    public AreaData findAreaData(Long areaId) {
        return areaDataRepository.findFirst1ByAid(areaId);
    }

    @Override
    public Collection<AreaData> getAllAreaData(){
        Iterable<AreaData> itr = areaDataRepository.findAll();
        return (Collection<AreaData>)itr;
    }
}
