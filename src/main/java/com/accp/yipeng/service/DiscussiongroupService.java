package com.accp.yipeng.service;

import java.util.List;

public interface DiscussiongroupService {
    
    //模糊查询 查用户 或讨论组
    
    List<Object> query(String name);
}
