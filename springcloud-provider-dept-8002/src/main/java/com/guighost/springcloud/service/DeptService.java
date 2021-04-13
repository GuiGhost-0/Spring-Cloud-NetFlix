package com.guighost.springcloud.service;

import com.guighost.springcloud.entity.Dept;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @interfaceName DeptService()
 * 描述：部门表业务接口
 */
public interface DeptService {
    public boolean addDept(Dept dept);

    public Dept getById(Long id);

    public List<Dept> getAll();
}
