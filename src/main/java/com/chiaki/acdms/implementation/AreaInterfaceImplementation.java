package com.chiaki.acdms.implementation;

import com.chiaki.acdms.entity.Area;
import com.chiaki.acdms.interfaceService.AreaInterface;
import com.chiaki.acdms.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class AreaInterfaceImplementation implements AreaInterface {
    @Autowired
    protected AreaRepository areaRepository;

    @Override
    public Area saveArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Boolean deleteArea(String areaName){
        Area temp = areaRepository.findOne(areaName);
        if(temp!=null){
            areaRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Area editArea(Area area){
        return areaRepository.save(area);
    }

    @Override
    public Area findArea(String areaName) {
        return areaRepository.findOne(areaName);
    }

    @Override
    public Collection<Area> getAllAreas(){
        Iterable<Area> itr = areaRepository.findAll();
        return (Collection<Area>)itr;
    }
}
