package com.chiaki.acdms.controller;

import com.chiaki.acdms.entity.Area;
import com.chiaki.acdms.entity.Device;
import com.chiaki.acdms.entity.Location;
import com.chiaki.acdms.entity.Probe;
import com.chiaki.acdms.interfaceService.ProbeInterface;
import com.chiaki.acdms.repository.AreaRepository;
import com.chiaki.acdms.repository.DeviceRepository;
import com.chiaki.acdms.repository.LocationRepository;
import com.chiaki.acdms.repository.ProbeRepository;
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
public class ProbeController {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ProbeRepository probeRepository;

    @Autowired
    ProbeInterface probeInterface;

    @RequestMapping(value = "/ProbeInfo_visitor/find")
    public String findProbeData_visitor(@RequestParam String locationname, @RequestParam String areaname,@RequestParam String deviceid,
                                         @RequestParam String locationtitle, @RequestParam String areatitle,@RequestParam String devicetitle,
                                         ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        Device device = deviceRepository.findFirst1ByDeviceId(devicetitle);
        model.addAttribute("device", device);
        List<Probe> probeList = probeRepository.findByLocationNameAndAreaNameAndDeviceId(locationname,areaname,deviceid);
        model.addAttribute("probeList", probeList);
        if ((locationname != null) && (areaname!=null) && (deviceid!=null)) {
            return "ProbeInfo_visitor_find";
        }
        return "redirect:/ProbeInfo_visitor";
    }

    @RequestMapping(value = "/ProbeInfo/find")
    public String findProbeData(@RequestParam String locationname, @RequestParam String areaname,@RequestParam String deviceid,
                                        @RequestParam String locationtitle, @RequestParam String areatitle,@RequestParam String devicetitle,
                                        ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        Device device = deviceRepository.findFirst1ByDeviceId(devicetitle);
        model.addAttribute("device", device);
        List<Probe> probeList = probeRepository.findByLocationNameAndAreaNameAndDeviceId(locationname,areaname,deviceid);
        model.addAttribute("probeList", probeList);
        if ((locationname != null) && (areaname!=null) && (deviceid!=null)) {
            return "ProbeInfo_find";
        }
        return "redirect:/ProbeInfo";
    }

    //增删改操作——设备信息
    @GetMapping("/DataManage_ProbeInfo")
    public String saveProbeInfoPage(Model model) {
        model.addAttribute("probeData", new Probe());
        model.addAttribute("allProbeData", (ArrayList<Probe>)probeInterface.getAllProbeData());
        return "DataManage_ProbeInfo";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/DataManage_ProbeInfo/save")
    public String saveProbeData(@ModelAttribute("probe") Probe probe,
                                 final RedirectAttributes redirectAttributes) {

        if(probeInterface.saveProbeData(probe)!=null) {
            redirectAttributes.addFlashAttribute("saveProbeData", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveProbeData", "unsuccess");
        }
        return "redirect:/DataManage_ProbeInfo";
    }

    @RequestMapping(value = "/DataManage_ProbeInfo/{operation}/{proId}", method = RequestMethod.GET)
    public String editRemoveProbeData(@PathVariable("operation") String operation,
                                       @PathVariable("proId") Long proId, final RedirectAttributes redirectAttributes,
                                       Model model) {
        if(operation.equals("delete")) {
            if(probeInterface.deleteProbeData(proId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            Probe editProbeData = probeInterface.findProbeData(proId);
            if(editProbeData!=null) {
                model.addAttribute("editProbeData", editProbeData);
                return "DataManage_ProbeInfo_edit";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/DataManage_ProbeInfo";
    }

    @RequestMapping(value = "/DataManage_ProbeInfo/update", method = RequestMethod.POST)
    public String updateProbe(@ModelAttribute("editProbeData") Probe editProbeData,
                               final RedirectAttributes redirectAttributes) {
        if(probeInterface.editProbeData(editProbeData)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/DataManage_ProbeInfo";
    }


}


