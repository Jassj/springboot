package com.yuanjie.springboot.mapper;

import com.yuanjie.springboot.pojo.Tudmkz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description
 * 实体映射类
 * @author yuanjie 2020/03/05 9:39
 */
@Mapper
@Component
public interface TudmkzMapper {

    @Select("select * from tu_dm_kz")
    List<Tudmkz> findAll();
}
