package io.github.stayhungrystayfoolish.dao;

import io.github.stayhungrystayfoolish.bean.ExUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bonismo@hotmail.com on 2018/9/4 下午3:48
 *
 * @Version: V1.0.0
 * <p>
 * Description:
 */
@Component
@Mapper
public interface ExUserDao {

    List<ExUser> queryAll();
}


