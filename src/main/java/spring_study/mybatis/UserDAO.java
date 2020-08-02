package spring_study.mybatis;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author lihaoyu
 * @date 2/22/2020 11:10 PM
 */
@Mapper
public interface UserDAO {
    int countUser();
}
