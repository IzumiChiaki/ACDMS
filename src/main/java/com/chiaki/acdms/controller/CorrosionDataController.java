package com.chiaki.acdms.controller;

import com.chiaki.acdms.entity.*;
import com.chiaki.acdms.interfaceService.CorrosionDataInterface;
import com.chiaki.acdms.repository.*;
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
public class CorrosionDataController {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    ProbeRepository probeRepository;

    @Autowired
    CorrosionDataRepository corrosionDataRepository;

    @Autowired
    CorrosionDataInterface corrosionDataInterface;

    @RequestMapping(value = "/CorrosionInfo_visitor/find")
    public String findCorrosionData_visitor(@RequestParam String locationname, @RequestParam String areaname,
                                            @RequestParam String deviceid, @RequestParam String probeid,
                                            @RequestParam String locationtitle, @RequestParam String areatitle,
                                            @RequestParam String devicetitle,@RequestParam String probetitle,
                                            ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        Device device = deviceRepository.findFirst1ByDeviceId(devicetitle);
        model.addAttribute("device", device);
        Probe probe = probeRepository.findFirst1ByProbeId(probetitle);
        model.addAttribute("probe", probe);
        List<CorrosionData> corrosionDataList = corrosionDataRepository
                .findByLocationNameAndAreaNameAndDeviceIdAndProbeId(locationname,areaname,deviceid,probeid);
        model.addAttribute("corrosionDataList", corrosionDataList);
        if ((locationname != null) && (areaname!=null) && (deviceid!=null) && (probeid!=null)) {
            return "CorrosionInfo_visitor_find";
        }
        return "redirect:/CorrosionInfo_visitor";
    }

    @RequestMapping(value = "/CorrosionInfo/find")
    public String findCorrosionData(@RequestParam String locationname, @RequestParam String areaname,
                                    @RequestParam String deviceid, @RequestParam String probeid,
                                    @RequestParam String locationtitle, @RequestParam String areatitle,
                                    @RequestParam String devicetitle,@RequestParam String probetitle,
                                    ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        Device device = deviceRepository.findFirst1ByDeviceId(devicetitle);
        model.addAttribute("device", device);
        Probe probe = probeRepository.findFirst1ByProbeId(probetitle);
        model.addAttribute("probe", probe);
        List<CorrosionData> corrosionDataList = corrosionDataRepository
                .findByLocationNameAndAreaNameAndDeviceIdAndProbeId(locationname,areaname,deviceid,probeid);
        model.addAttribute("corrosionDataList", corrosionDataList);
        if ((locationname != null) && (areaname!=null) && (deviceid!=null) && (probeid!=null)) {
            return "CorrosionInfo_find";
        }
        return "redirect:/CorrosionInfo";
    }

    //增删改操作——设备信息
    @GetMapping("/DataManage_CorrosionInfo")
    public String saveCorrosionInfoPage(Model model) {
        model.addAttribute("corrosionData", new CorrosionData());
        model.addAttribute("allCorrosionData", (ArrayList<CorrosionData>)corrosionDataInterface.getAllCorrosionData());
        return "DataManage_CorrosionInfo";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/DataManage_CorrosionInfo/save")
    public String saveCorrosionData(@ModelAttribute("corrosionData") CorrosionData corrosionData,
                                final RedirectAttributes redirectAttributes) {

        if(corrosionDataInterface.saveCorrosionData(corrosionData)!=null) {
            redirectAttributes.addFlashAttribute("saveCorrosionData", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveCorrosionData", "unsuccess");
        }
        return "redirect:/DataManage_CorrosionInfo";
    }

    @RequestMapping(value = "/DataManage_CorrosionInfo/{operation}/{cId}", method = RequestMethod.GET)
    public String editRemoveCorrosionData(@PathVariable("operation") String operation,
                                      @PathVariable("cId") Long cId, final RedirectAttributes redirectAttributes,
                                      Model model) {
        if(operation.equals("delete")) {
            if(corrosionDataInterface.deleteCorrosionData(cId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            CorrosionData editCorrosionData = corrosionDataInterface.findCorrosionData(cId);
            if(editCorrosionData!=null) {
                model.addAttribute("editCorrosionData", editCorrosionData);
                return "DataManage_CorrosionInfo_edit";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/DataManage_CorrosionInfo";
    }

    @RequestMapping(value = "/DataManage_CorrosionInfo/update", method = RequestMethod.POST)
    public String updateCorrosionData(@ModelAttribute("editCorrosionData") CorrosionData editCorrosionData,
                              final RedirectAttributes redirectAttributes) {
        if(corrosionDataInterface.editCorrosionData(editCorrosionData)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/DataManage_CorrosionInfo";
    }
}
