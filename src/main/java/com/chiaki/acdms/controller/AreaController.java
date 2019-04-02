package com.chiaki.acdms.controller;

import com.chiaki.acdms.entity.Area;
import com.chiaki.acdms.entity.AreaData;
import com.chiaki.acdms.entity.Location;
import com.chiaki.acdms.interfaceService.AreaDataInterface;
import com.chiaki.acdms.interfaceService.AreaInterface;
import com.chiaki.acdms.repository.AreaDataRepository;
import com.chiaki.acdms.repository.AreaRepository;
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
public class AreaController {
    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    AreaInterface areaInterface;

    @Autowired
    AreaDataRepository areaDataRepository;

    @Autowired
    AreaDataInterface areaDataInterface;

    @RequestMapping(value = "/AreaInfo_visitor/find")
    public String findAreaData_visitor(@RequestParam String areaname, @RequestParam String locationtitle,@RequestParam String areatitle, ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        List<AreaData> areaData = areaDataRepository.findByAreaName(areaname);
        model.addAttribute("areaData", areaData);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        if (areaname != null) {
            return "AreaInfo_visitor_find";
        }
        return "redirect:/AreaInfo_visitor";
    }



    @RequestMapping(value = "/AreaInfo/find")
    public String findAreaData(@RequestParam String areaname, @RequestParam String locationtitle,@RequestParam String areatitle, ModelMap model) {
        Location location = locationRepository.findByLocationName(locationtitle);
        model.addAttribute("location",location);
        List<AreaData> areaData = areaDataRepository.findByAreaName(areaname);
        model.addAttribute("areaData", areaData);
        Area area = areaRepository.findByAreaName(areatitle);
        model.addAttribute("area", area);
        if (areaname != null) {
            return "AreaInfo_find";
        }

        return "redirect:/AreaInfo";
    }

    //增删改操作——区域名称信息
    @GetMapping("/DataManage_AreaName")
    public String savePage(Model model) {
        model.addAttribute("area", new Area());
        model.addAttribute("allAreas", (ArrayList<Area>)areaInterface.getAllAreas());
        return "DataManage_AreaName";
    }

    @PostMapping("/DataManage_AreaName/save")
    public String saveArea(@ModelAttribute("area") Area area,
                               final RedirectAttributes redirectAttributes) {

        if(areaInterface.saveArea(area)!=null) {
            redirectAttributes.addFlashAttribute("saveArea", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveArea", "unsuccess");
        }
        return "redirect:/DataManage_AreaName";
    }

    @RequestMapping(value = "/DataManage_AreaName/{operation}/{areaName}", method = RequestMethod.GET)
    public String editRemoveArea(@PathVariable("operation") String operation,
                                     @PathVariable("areaName") String areaName, final RedirectAttributes redirectAttributes,
                                     Model model) {
        if(operation.equals("delete")) {
            if(areaInterface.deleteArea(areaName)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            Area editArea = areaInterface.findArea(areaName);
            if(editArea!=null) {
                model.addAttribute("editArea", editArea);
                return "DataManage_AreaName_edit";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/DataManage_AreaName";
    }

    @RequestMapping(value = "/DataManage_AreaName/update", method = RequestMethod.POST)
    public String updateArea(@ModelAttribute("editArea") Area editArea,
                                 final RedirectAttributes redirectAttributes) {
        if(areaInterface.editArea(editArea)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/DataManage_AreaName";
    }

    //增删改操作——区域天气信息
    @GetMapping("/DataManage_AreaInfo")
    public String saveAreaInfoPage(Model model) {
        model.addAttribute("areaData", new AreaData());
        model.addAttribute("allAreaData", (ArrayList<AreaData>)areaDataInterface.getAllAreaData());
        return "DataManage_AreaInfo";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @PostMapping("/DataManage_AreaInfo/save")
    public String saveAreaData(@ModelAttribute("areaData") AreaData areaData,
                                   final RedirectAttributes redirectAttributes) {

        if(areaDataInterface.saveAreaData(areaData)!=null) {
            redirectAttributes.addFlashAttribute("saveAreaData", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveAreaData", "unsuccess");
        }
        return "redirect:/DataManage_AreaInfo";
    }

    @RequestMapping(value = "/DataManage_AreaInfo/{operation}/{areaId}", method = RequestMethod.GET)
    public String editRemoveAreaData(@PathVariable("operation") String operation,
                                         @PathVariable("areaId") Long areaId, final RedirectAttributes redirectAttributes,
                                         Model model) {
        if(operation.equals("delete")) {
            if(areaDataInterface.deleteAreaData(areaId)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if(operation.equals("edit")){
            AreaData editAreaData = areaDataInterface.findAreaData(areaId);
            if(editAreaData!=null) {
                model.addAttribute("editAreaData", editAreaData);
                return "DataManage_AreaInfo_edit";
            } else {
                redirectAttributes.addFlashAttribute("status","notfound");
            }
        }
        return "redirect:/DataManage_AreaInfo";
    }

    @RequestMapping(value = "/DataManage_AreaInfo/update", method = RequestMethod.POST)
    public String updateArea(@ModelAttribute("editAreaData") AreaData editAreaData,
                                 final RedirectAttributes redirectAttributes) {
        if(areaDataInterface.editAreaData(editAreaData)!=null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/DataManage_AreaInfo";
    }
}
