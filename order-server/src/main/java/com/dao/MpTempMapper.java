package com.dao;

import com.entity.MpTemp;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MpTempMapper extends Mapper<MpTemp> {
    int updateStatus(@Param("orderId") String orderId);
}