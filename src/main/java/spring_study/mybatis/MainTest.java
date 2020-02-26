package spring_study.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;

/**
 * @author lihaoyu
 * @date 2/22/2020 11:08 PM
 */
public class MainTest {


    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatisConfig.xml"));
        SqlSession sqlSession = factory.openSession();
        UserDAO mapper = sqlSession.getMapper(UserDAO.class);
        mapper.countUser();
    }
}
