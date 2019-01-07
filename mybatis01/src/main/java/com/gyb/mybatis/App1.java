package com.gyb.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.gyb.mybatis.common.DruidDataSourceFactory;
import com.gyb.mybatis.entity.User;
import com.gyb.mybatis.mapper.TestMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeAliasRegistry;

import javax.sql.DataSource;
import java.util.List;

/**
 * 通过java 配置MyBatis环境
 * @author gengyuanbo
 * 2019/01/07
 */
public class App1 {
    public static void main(String[] args) {
        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        Environment devEnv = new Environment("development", jdbcTransactionFactory, druidDataSource);

        Configuration configuration = new Configuration(devEnv);

        configuration.addMappers("com.gyb.mybatis.mapper");
        TypeAliasRegistry typeAliasRegistry = configuration.getTypeAliasRegistry();
        typeAliasRegistry.registerAliases("com.gyb.mybatis.entity");


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);

        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();

    }
}
