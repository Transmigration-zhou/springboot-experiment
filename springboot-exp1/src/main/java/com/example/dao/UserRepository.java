package com.example.dao;

import com.example.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface  UserRepository extends JpaRepository<UserDto, Integer> {
    List<UserDto> findAllByLoginNameAndType(String loginName, Integer type);

    int deleteUserByLoginName(String userName);

    UserDto findByLoginName(String userName);

    UserDto findAllById(Integer id);
}
