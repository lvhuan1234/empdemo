package com.neuedu.service.impl;

import com.neuedu.entity.Dept;
import com.neuedu.entity.Emp;
import com.neuedu.mapper.DeptMapper;
import com.neuedu.mapper.EmpMapper;
import com.neuedu.service.DeptService;
import com.neuedu.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public List<Dept> deptList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.deptList();
        sqlSession.close();
        return deptList;
    }
}
