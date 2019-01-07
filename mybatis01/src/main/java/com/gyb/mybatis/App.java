package com.gyb.mybatis;

import com.gyb.mybatis.entity.User;
import com.gyb.mybatis.mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        User user = mapper.selectById(1);
        System.out.println(user);
        List<User> users = mapper.selectAll();
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
}
