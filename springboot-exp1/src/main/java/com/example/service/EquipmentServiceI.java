package com.example.service;

import com.example.pojo.Equipment;

import java.util.List;

public interface EquipmentServiceI {
    List<Equipment> getEquipment(Integer id);
    void addEquipment(Equipment equipment);
    Equipment getEquipmentById(Integer id);
    void updateEquipment(Equipment equipment);
    void deleteEquipment(Integer id);
    List<Equipment> getAllEquipment();
}
