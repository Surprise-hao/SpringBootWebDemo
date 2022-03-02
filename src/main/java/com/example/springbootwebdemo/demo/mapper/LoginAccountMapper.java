package com.example.springbootwebdemo.demo.mapper;

import com.example.springbootwebdemo.demo.entity.LoginAccountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 登录账户 Mapper 接口
 * </p>
 *
 * @author xiamu
 * @since 2022-01-20
 */
@Mapper
public interface LoginAccountMapper extends BaseMapper<LoginAccountEntity> {

}
