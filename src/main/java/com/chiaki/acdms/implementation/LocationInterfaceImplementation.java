package com.chiaki.acdms.implementation;

import com.chiaki.acdms.interfaceService.LocationInterface;
import com.chiaki.acdms.entity.Location;
import com.chiaki.acdms.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class LocationInterfaceImplementation implements LocationInterface {

    @Autowired
    protected LocationRepository locationRepository;

    @Override
    public Location saveLocation(Location loc) {
        return locationRepository.save(loc);
    }

    @Override
    public Boolean deleteLocation(String locName){
        Location temp = locationRepository.findOne(locName);
        if(temp!=null){
            locationRepository.delete(temp);
            return true;
        }
        return false;
    }

    @Override
    public Location editLocation(Location loc){
        return locationRepository.save(loc);
    }

    @Override
    public Location findLocation(String locName) {
        return locationRepository.findOne(locName);
    }

    @Override
    public Collection<Location> getAllLocations(){
        Iterable<Location> itr = locationRepository.findAll();
        return (Collection<Location>)itr;
    }
}
