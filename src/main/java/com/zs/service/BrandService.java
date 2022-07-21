package com.zs.service;

import com.zs.mapper.BrandMapper;
import com.zs.pojo.Brand;
import com.zs.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll(){

        SqlSession session = factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        session.close();
        return brands;
    }

    public void add(Brand brand){
        SqlSession session = factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);

        mapper.add(brand);

        session.commit();

        session.close();
    }

    public Brand selectById(int id){

        SqlSession session = factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(id);

        session.close();

        return brand;
    }

    public void update(Brand brand){
        SqlSession session = factory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);

        mapper.update(brand);

        session.commit();

        session.close();
    }
}
