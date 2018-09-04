package io.github.stayhungrystayfoolish.service;

import io.github.stayhungrystayfoolish.bean.ExUser;
import io.github.stayhungrystayfoolish.dao.ExUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bonismo@hotmail.com on 2018/9/4 下午4:49
 *
 * @Version: V1.0.0
 * <p>
 * Description:
 */
@Service
@Transactional
public class ExUserService {

    @Autowired
    private ExUserDao userDao;

    public List<ExUser> getUser() {
        return userDao.queryAll();
    }
}


