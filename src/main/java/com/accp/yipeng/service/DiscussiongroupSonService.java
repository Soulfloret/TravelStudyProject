package com.accp.yipeng.service;

import com.accp.domain.discussiongroupson;

public interface DiscussiongroupSonService {
    int insert(discussiongroupson record);
    public int selectCountBydid(Integer did);

}
