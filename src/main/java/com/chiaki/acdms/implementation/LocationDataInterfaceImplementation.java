package com.chiaki.acdms.implementation;

import com.chiaki.acdms.entity.Location;
import com.chiaki.acdms.entity.LocationData;
import com.chiaki.acdms.interfaceService.LocationDataInterface;
import com.chiaki.acdms.repository.LocationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class LocationDataInterfaceImplementation implements LocationDataInterface {

    @Autowired
    LocationDataRepository locationDataRepository;

    @Override
    public LocationData saveLocationData(LocationData locData){
        return locationDataRepository.save(locData);
    }

    @Override
    public Boolean deleteLocationData(Long locId){
        LocationData temp = locationDataRepository.findFirst1ByLid(locId);
        if(temp!=null){
            locationDataRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public LocationData editLocationData(LocationData locData){
        return locationDataRepository.save(locData);
    }

    @Override
    public LocationData findLocationData(Long locId) {
        return locationDataRepository.findFirst1ByLid(locId);
    }

    @Override
    public Collection<LocationData> getAllLocationData(){
        Iterable<LocationData> itr = locationDataRepository.findAll();
        return (Collection<LocationData>)itr;
    }

}
