package com.chiaki.acdms.controller;

import com.chiaki.acdms.entity.*;
import com.chiaki.acdms.repository.*;
import com.chiaki.acdms.service.AreaWithLocationService;
import com.chiaki.acdms.service.DeviceWithAreaService;
import com.chiaki.acdms.service.ProbeWithDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    LocationDataRepository locationDataRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    AreaDataRepository areaDataRepository;

    @Autowired
    AreaWithLocationService areaWithLocationService;

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceWithAreaService deviceWithAreaService;

    @Autowired
    ProbeRepository probeRepository;

    @Autowired
    ProbeWithDeviceService probeWithDeviceService;

    @Autowired
    CorrosionDataRepository corrosionDataRepository;

    @RequestMapping(value = {"/","/login"})
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/Homepage")
    public String homepage(Model model) {
        return "Homepage";
    }

    @GetMapping("/SysIntroduction")
    public String sysIntroduction(Model model) {
        return "SysIntroduction";
    }

    @GetMapping("/SysIntroduction_visitor")
    public String sysIntroduction_visitor(Model model) {
        return "SysIntroduction_visitor";
    }

    @GetMapping("/SysFrame")
    public String sysFrame(Model model) {
        return "SysFrame";
    }

    @GetMapping("/SysFrame_visitor")
    public String sysFrame_visitor(Model model) {
        return "SysFrame_visitor";
    }

    @GetMapping("/SysFunction")
    public String sysFunction(Model model) {
        return "SysFunction";
    }

    @GetMapping("/SysFunction_visitor")
    public String sysFunction_visitor(Model model) {
        return "SysFunction_visitor";
    }

    @GetMapping("/SysSense")
    public String sysSense(Model model) {
        return "SysSense";
    }

    @GetMapping("/SysSense_visitor")
    public String sysSense_visitor(Model model) {
        return "SysSense_visitor";
    }

    //地点信息查询控制
    @GetMapping("/LocationInfo")
    public String locationInfo(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<LocationData> locationDataNameLists = locationDataRepository.findAll();
        session.setAttribute("locationDataNameLists",locationDataNameLists);
        return "LocationInfo";
    }

    @GetMapping("/LocationInfo_visitor")
    public String locationInfo_visitor(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<LocationData> locationDataNameLists = locationDataRepository.findAll();
        session.setAttribute("locationDataNameLists",locationDataNameLists);
        return "LocationInfo_visitor";
    }

    //区域信息查询控制
    @GetMapping("/AreaInfo")
    public String areaInfo(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        return "AreaInfo_ajax";
    }

    @GetMapping("/AreaInfo_visitor")
    public String areaInfo_visitor(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        return "AreaInfo_visitor_ajax";

    }

    @RequestMapping(value = {"/AreaInfo_ajax","/AreaInfo_find","/AreaInfo_visitor_ajax","/AreaInfo_visitor_find"},
            method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<Area> areaNameInfo_visitor_ajax(HttpServletRequest request) {
        String locationName= request.getParameter("location_name");
        System.out.println(locationName);
        List<Area> areaDataList = areaWithLocationService.areaNameInfo(locationName);
        return areaDataList;

    }


    //设备信息查询控制
    @GetMapping("/DeviceInfo")
    public String deviceInfo(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        List<Device> deviceNameLists = deviceRepository.findAll();
        session.setAttribute("deviceNameLists",deviceNameLists);
        return "DeviceInfo_ajax";
    }

    @GetMapping("/DeviceInfo_visitor")
    public String deviceInfo_visitor(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        List<Device> deviceNameLists = deviceRepository.findAll();
        session.setAttribute("deviceNameLists",deviceNameLists);
        return "DeviceInfo_visitor_ajax";
    }

    //探针信息查询控制
    @GetMapping("/ProbeInfo")
    public String probeInfo(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        List<Device> deviceNameLists = deviceRepository.findAll();
        session.setAttribute("deviceNameLists",deviceNameLists);
        List<Probe> probeNameLists = probeRepository.findAll();
        session.setAttribute("probeNameLists",probeNameLists);
        return "ProbeInfo_ajax";
    }

    @GetMapping("/ProbeInfo_visitor")
    public String probeInfo_visitor(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        List<Device> deviceNameLists = deviceRepository.findAll();
        session.setAttribute("deviceNameLists",deviceNameLists);
        List<Probe> probeNameLists = probeRepository.findAll();
        session.setAttribute("probeNameLists",probeNameLists);
        return "ProbeInfo_visitor_ajax";
    }

    @RequestMapping(value = {"/ProbeInfo_visitor_find","/ProbeInfo_visitor_ajax","/ProbeInfo_find","/ProbeInfo_ajax"},
            method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<Device> deviceNameInfo_visitor_find(HttpServletRequest request) {
        String areaName= request.getParameter("areaname");
        System.out.println(areaName);
        List<Device> deviceDataList = deviceWithAreaService.deviceIdInfo(areaName);
        return deviceDataList;
    }

    //探针信息查询控制
    @GetMapping("/CorrosionInfo")
    public String corrosionInfo(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        List<Device> deviceNameLists = deviceRepository.findAll();
        session.setAttribute("deviceNameLists",deviceNameLists);
        List<Probe> probeNameLists = probeRepository.findAll();
        session.setAttribute("probeNameLists",probeNameLists);
        List<CorrosionData> corrosionDataLists = corrosionDataRepository.findAll();
        session.setAttribute("corrosionDataLists",corrosionDataLists);
        return "CorrosionInfo_ajax";
    }

    @GetMapping("/CorrosionInfo_visitor")
    public String corrosionInfo_visitor(HttpSession session) {
        List<Location> locationNameLists = locationRepository.findAll();
        session.setAttribute("locationNameLists",locationNameLists);
        List<Area> areaNameLists = areaRepository.findAll();
        session.setAttribute("areaNameLists",areaNameLists);
        List<AreaData> areaDataNameLists = areaDataRepository.findAll();
        session.setAttribute("areaDataNameLists",areaDataNameLists);
        List<Device> deviceNameLists = deviceRepository.findAll();
        session.setAttribute("deviceNameLists",deviceNameLists);
        List<Probe> probeNameLists = probeRepository.findAll();
        session.setAttribute("probeNameLists",probeNameLists);
        List<CorrosionData> corrosionDataLists = corrosionDataRepository.findAll();
        session.setAttribute("corrosionDataLists",corrosionDataLists);
        return "CorrosionInfo_visitor_ajax";
    }

    @RequestMapping(value = {"/CorrosionInfo_visitor_find","/CorrosionInfo_visitor_ajax","/CorrosionInfo_find","/CorrosionInfo_ajax"},
            method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<Probe> corrosionDataInfo_visitor_find(HttpServletRequest request) {
        String locationName = request.getParameter("location_name");
        String areaName = request.getParameter("areaname");
        String deviceId = request.getParameter("deviceid");
        System.out.println(locationName);
        System.out.println(areaName);
        System.out.println(deviceId);
        List<Probe> CorrosionDataList = probeWithDeviceService.probeIdInfo(locationName, areaName, deviceId);
        return CorrosionDataList;
    }
}