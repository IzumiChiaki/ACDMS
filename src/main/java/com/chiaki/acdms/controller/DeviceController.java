package com.chiaki.acdms.controller;

import com.chiaki.acdms.entity.Area;
import com.chiaki.acdms.entity.Device;
import com.chiaki.acdms.entity.Location;
import com.chiaki.acdms.interfaceService.DeviceInterface;
import com.chiaki.acdms.repository.AreaRepository;
import com.chiaki.acdms.repository.DeviceRepository;
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
public class DeviceController {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceInterface deviceInterface;

    @RequestMapping(value = "/DeviceInfo_visitor/find")
    public String findDeviceData_visitor(@RequestParam String locationname,@RequestParam String areaname,
                                         @RequestParam String locationtitle, @RequestParam String areatitle,
                                         ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        List<Device> deviceList = deviceRepository.findByLocationNameAndAreaName(locationname,areaname);
        model.addAttribute("deviceList", deviceList);
        if ((locationname != null) && (areaname!=null)) {
            return "DeviceInfo_visitor_find";
        }
        return "redirect:/DeviceInfo_visitor";
    }


    @RequestMapping(value = "/DeviceInfo/find")
    public String findDeviceData(@RequestParam String locationname,@RequestParam String areaname,
                                 @RequestParam String locationtitle, @RequestParam String areatitle,
                                 ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        List<Device> deviceList = deviceRepository.findByLocationNameAndAreaName(locationname,areaname);
        model.addAttribute("deviceList", deviceList);
        if ((locationname != null) && (areaname!=null)) {
            return "DeviceInfo_find";
        }
        return "redirect:/DeviceInfo";
    }

    //增删改操作——设备信息
    @GetMapping("/DataManage_DeviceInfo")
    public String saveDeviceInfoPage(Model model) {
        model.addAttribute("deviceData", new Device());
        model.addAttribute("allDeviceData", (ArrayList<Device>)deviceInterface.getAllDeviceData());
        return "DataManage_DeviceInfo";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/DataManage_DeviceInfo/save")
    public String saveDeviceData(@ModelAttribute("device") Device device,
                               final RedirectAttributes redirectAttributes) {

        if(deviceInterface.saveDeviceData(device)!=null) {
            redirectAttributes.addFlashAttribute("saveDeviceData", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveDeviceData", "unsuccess");
        }
        return "redirect:/DataManage_DeviceInfo";
    }

    @RequestMapping(value = "/DataManage_DeviceInfo/{operation}/{devId}", method = RequestMethod.GET)
    public String editRemoveDeviceData(@PathVariable("operation") String operation,
                                     @PathVariable("devId") Long devId, final RedirectAttributes redirectAttributes,
                                     Model model) {
        if(operation.equals("delete")) {
            if(deviceInterface.deleteDeviceData(devId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            Device editDeviceData = deviceInterface.findDeviceData(devId);
            if(editDeviceData!=null) {
                model.addAttribute("editDeviceData", editDeviceData);
                return "DataManage_DeviceInfo_edit";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/DataManage_DeviceInfo";
    }

    @RequestMapping(value = "/DataManage_DeviceInfo/update", method = RequestMethod.POST)
    public String updateDevice(@ModelAttribute("editDeviceData") Device editDeviceData,
                             final RedirectAttributes redirectAttributes) {
        if(deviceInterface.editDeviceData(editDeviceData)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/DataManage_DeviceInfo";
    }
}
