package com.guighost.springcloud.service.impl;

import com.guighost.springcloud.dao.DeptDao;
import com.guighost.springcloud.entity.Dept;
import com.guighost.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @className DeptServiceImpl()
 * 描述：部门表业务接口实现类
 */
@Service   //将该类注入到Spring容器
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept getById(Long id) {
        return deptDao.getById(id);
    }

    @Override
    public List<Dept> getAll() {
        return deptDao.getAll();
    }
}
