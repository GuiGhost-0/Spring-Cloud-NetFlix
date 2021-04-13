package com.guighost.springcloud.dao;

import com.guighost.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author GuiGhost
 * @date 2021/04/07
 * @interfaceName DeptDao()
 * 描述：数据访问层接口
 */
@Mapper    //该注解是为了这个接口在编译时会生成相应的实现类
@Repository    //该注解是为了将该类注入到Spring容器
public interface DeptDao {
    public boolean addDept(Dept dept);

    public Dept getById(@Param("deptno") Long id);

    public List<Dept> getAll();
}
