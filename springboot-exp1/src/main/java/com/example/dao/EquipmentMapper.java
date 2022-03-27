package com.example.dao;

import com.example.pojo.Equipment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EquipmentMapper {
    @Select(("select * from tequipment where user_id=#{id}"))
    List<Equipment> getEquipment(int id);

    @Insert("insert into tequipment(id,name,description,code,add_time,price,place,user_id) value(#{id},#{name},#{description},#{code},#{addTime},#{price},#{place},#{userId});")
    void addEquipment(Equipment equipment);

    @Select("select * from tequipment where id=#{id}")
    Equipment getEquipmentById(Integer id);

    @Update("update tequipment set description = #{description},code = #{code},price = #{price},place = #{place},user_id =#{userId} where name = #{name};")
    void updataEquipment(Equipment equipment);

    @Delete("delete from tequipment where id = #{id};")
    void deleteEquipment(Integer id);

    @Select("select * from tequipment")
    List<Equipment> getAllEquipment();
}
