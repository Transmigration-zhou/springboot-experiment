package com.example.service.impl;

import com.example.dao.EquipmentMapper;
import com.example.pojo.Equipment;
import com.example.service.EquipmentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentServiceI {
    @Autowired
    EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> getEquipment(Integer id) {
        return equipmentMapper.getEquipment(id);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipmentMapper.addEquipment(equipment);
    }

    @Override
    public Equipment getEquipmentById(Integer id) {
        return equipmentMapper.getEquipmentById(id);
    }

    @Override
    public void updateEquipment(Equipment equipment) {
        equipmentMapper.updataEquipment(equipment);
    }

    @Override
    public void deleteEquipment(Integer id) {
        equipmentMapper.deleteEquipment(id);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentMapper.getAllEquipment();
    }
}
