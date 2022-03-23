package com.example.service;

import com.example.dto.EquipmentDto;

import java.util.List;

public interface EquipmentServiceI {
    //添加
    EquipmentDto save(EquipmentDto tequipment);

    //修改
    EquipmentDto update(EquipmentDto tequipment);

    //删除
    void delEquipment(int tequipmentId);

    //管理员查询所有设备
    List<EquipmentDto> queryAllEquipment();

    //个人查看自己的设备
    List<EquipmentDto> querySelfEquipment(Integer userId);

    //管理员查看某个人的设备信息
    List<EquipmentDto> queryOnesEquipment(Integer userId);

    //管理员分配设备
    int issueEquipment(int userId, int equipmentId);

    //管理员回收设备
    int recoveryEquipment(int userId, int equipmentId);
}
