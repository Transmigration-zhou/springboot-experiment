package com.example.controller;

import com.example.pojo.Equipment;
import com.example.service.EquipmentServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "设备管理")
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    EquipmentServiceI equipmentService;

    @PostMapping("/addEquipment")
    @ApiOperation("添加设备")
    public String addEquipment(Equipment tequipment) {
        equipmentService.addEquipment(tequipment);
        return "添加成功";
    }

    @PostMapping("/updateEquipment")
    @ApiOperation("修改设备")
    public String updateEquipment(Equipment tequipment) {
        equipmentService.updateEquipment(tequipment);
        return "修改成功";
    }

    @DeleteMapping("/deleteEquipment")
    @ApiOperation("删除设备")
    public String deleteEquipment(Integer id) {
        equipmentService.deleteEquipment(id);
        return "删除成功";
    }

    @GetMapping("/getAllEquipment")
    @ApiOperation("查看所有设备")
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @PostMapping("/getOneEquipment")
    @ApiOperation("根据设备Id查看设备")
    public List<Equipment> getOneEquipment(Integer id) {
        return equipmentService.getEquipment(id);
    }

    @PostMapping("/getEquiment")
    @ApiOperation("查询自己名下的设备")
    public List<Equipment> grtEquipment(Integer id) {
        return equipmentService.getEquipment(id);
    }
}
