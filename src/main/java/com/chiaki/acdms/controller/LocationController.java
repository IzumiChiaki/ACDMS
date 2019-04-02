package com.chiaki.acdms.controller;

import com.chiaki.acdms.entity.Location;
import com.chiaki.acdms.entity.LocationData;
import com.chiaki.acdms.interfaceService.LocationDataInterface;
import com.chiaki.acdms.interfaceService.LocationInterface;
import com.chiaki.acdms.repository.LocationDataRepository;
import com.chiaki.acdms.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@ComponentScan
public class LocationController {

    @Autowired
    LocationDataRepository locationDataRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    LocationInterface locationInterface;
    @Autowired
    LocationDataInterface locationDataInterface;

    //查询操作
    @RequestMapping(value = "/LocationInfo_visitor/find")
    public String findLocationData_visitor(@RequestParam String locationname,@RequestParam String locationtitle,ModelMap model) {
        List<LocationData> locationData = locationDataRepository.findByLocationName(locationname);
        model.addAttribute("locationData", locationData);
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location", location);
        if (locationname != null) {
            return "LocationInfo_visitor_find";
        }
        return "redirect:/LocationInfo_visitor";
    }


    @RequestMapping(value = "/LocationInfo/find")
    public String findLocationData(@RequestParam String locationname, @RequestParam String locationtitle, ModelMap model) {
        List<LocationData> locationData = locationDataRepository.findByLocationName(locationname);
        model.addAttribute("locationData", locationData);
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location", location);
        if (locationname != null) {
            return "LocationInfo_find";
        }
        return "redirect:/LocationInfo";
    }

    //增删改操作——地点名称信息
    @GetMapping("/DataManage_LocationName")
    public String savePage(Model model) {
        model.addAttribute("loc", new Location());
        model.addAttribute("allLocations", (ArrayList<Location>)locationInterface.getAllLocations());
        return "DataManage_LocationName";
    }

    @PostMapping("/DataManage_LocationName/save")
    public String saveLocation(@ModelAttribute("location") Location location,
                               final RedirectAttributes redirectAttributes) {

        if(locationInterface.saveLocation(location)!=null) {
            redirectAttributes.addFlashAttribute("saveLocation", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveLocation", "unsuccess");
        }
        return "redirect:/DataManage_LocationName";
    }

    @RequestMapping(value = "/DataManage_LocationName/{operation}/{locName}", method = RequestMethod.GET)
    public String editRemoveLocation(@PathVariable("operation") String operation,
                                     @PathVariable("locName") String locName, final RedirectAttributes redirectAttributes,
                                     Model model) {
        if(operation.equals("delete")) {
            if(locationInterface.deleteLocation(locName)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            Location editLocation = locationInterface.findLocation(locName);
            if(editLocation!=null) {
                model.addAttribute("editLocation", editLocation);
                return "DataManage_LocationName_edit";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/DataManage_LocationName";
    }

    @RequestMapping(value = "/DataManage_LocationName/update", method = RequestMethod.POST)
    public String updateLocation(@ModelAttribute("editLocation") Location editLocation,
                                 final RedirectAttributes redirectAttributes) {
        if(locationInterface.editLocation(editLocation)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/DataManage_LocationName";
    }

    //增删改操作——地点天气信息
    @GetMapping("/DataManage_LocationInfo")
    public String saveLocationInfoPage(Model model) {
        model.addAttribute("locData", new LocationData());
        model.addAttribute("allLocationData", (ArrayList<LocationData>)locationDataInterface.getAllLocationData());
        return "DataManage_LocationInfo";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/DataManage_LocationInfo/save")
    public String saveLocationData(@ModelAttribute("locData") LocationData locationData,
                               final RedirectAttributes redirectAttributes) {

        if(locationDataInterface.saveLocationData(locationData)!=null) {
            redirectAttributes.addFlashAttribute("saveLocationData", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveLocationData", "unsuccess");
        }
        return "redirect:/DataManage_LocationInfo";
    }

    @RequestMapping(value = "/DataManage_LocationInfo/{operation}/{locId}", method = RequestMethod.GET)
    public String editRemoveLocationData(@PathVariable("operation") String operation,
                                     @PathVariable("locId") Long locId, final RedirectAttributes redirectAttributes,
                                     Model model) {
        if(operation.equals("delete")) {
            if(locationDataInterface.deleteLocationData(locId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            LocationData editLocationData = locationDataInterface.findLocationData(locId);
            if(editLocationData!=null) {
                model.addAttribute("editLocationData", editLocationData);
                return "DataManage_LocationInfo_edit";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/DataManage_LocationInfo";
    }

    @RequestMapping(value = "/DataManage_LocationInfo/update", method = RequestMethod.POST)
    public String updateLocation(@ModelAttribute("editLocationData") LocationData editLocationData,
                                 final RedirectAttributes redirectAttributes) {
        if(locationDataInterface.editLocationData(editLocationData)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/DataManage_LocationInfo";
    }

}