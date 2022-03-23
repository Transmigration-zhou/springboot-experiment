package com.example.service.impl;

import com.example.dao.EquipmentRepository;
import com.example.dto.EquipmentDto;
import com.example.service.EquipmentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentServiceI {
    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public EquipmentDto save(EquipmentDto equipment) {
        EquipmentDto equipment1 = equipmentRepository.save(equipment);
        return equipment;
    }

    @Override
    public EquipmentDto update(EquipmentDto equipment) {
        List<EquipmentDto> equipmentList = equipmentRepository.findAll();
        for (EquipmentDto e : equipmentList) {
            if (equipment.getId().equals(e.getId())) {
                e.setPlace(equipment.getPlace());
                e.setPrice(equipment.getPrice());
                e.setCode(equipment.getCode());
                e.setName(equipment.getName());
                e.setDescription(equipment.getDescription());
                return e;
            }
        }

        return null;
    }

    @Override
    public void delEquipment(int equipmentId) {
        equipmentRepository.deleteById(equipmentId);
    }

    @Override
    public List<EquipmentDto> queryAllEquipment() {
        List<EquipmentDto> equipmentList = equipmentRepository.findAll();
        return equipmentList;
    }

    @Override
    public List<EquipmentDto> querySelfEquipment(Integer userId) {
        List<EquipmentDto> equipmentList = equipmentRepository.findAll();
        List<EquipmentDto> equipmentList1 = new ArrayList<>();
        for (EquipmentDto e : equipmentList) {
            if (e.getUserId().equals(userId)) {
                equipmentList1.add(e);
            }
        }
        return equipmentList1;
    }

    @Override
    public List<EquipmentDto> queryOnesEquipment(Integer userId) {
        List<EquipmentDto> equipmentList = equipmentRepository.findAll();
        List<EquipmentDto> equipmentList1 = new ArrayList<>();
        for (EquipmentDto e : equipmentList) {
            if (e.getUserId().equals(userId)) {
                equipmentList1.add(e);
            }
        }
        return equipmentList1;
    }

    @Override
    public int issueEquipment(int equipmentId, int userId) {
        List<EquipmentDto> equipmentList = equipmentRepository.findAll();
        if (equipmentList != null) {
            for (EquipmentDto e : equipmentList) {
                if (e.getId().equals(equipmentId)) {
                    e.setUserId(userId);
                }
            }
            return 1;
        }
        else return -1;

    }

    @Override
    public int recoveryEquipment(int userId, int equipmentId) {
        List<EquipmentDto> equipmentList = equipmentRepository.findAll();
        if (equipmentList != null) {
            for (EquipmentDto e : equipmentList) {
                if (e.getId().equals(equipmentId)) {
                    e.setUserId(null);
                }
            }
            return 1;
        }
        else return -1;
    }
}