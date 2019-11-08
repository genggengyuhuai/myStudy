package design_pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lihaoyu
 * @date 2019/11/8 9:14
 */

interface UserService {
    void add();
}

class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("添加用户");
    }
}

class UserTransaction {
    public void before() {
        System.out.println("开启事务");
    }

    public void after() {
        System.out.println("结束事务");
    }
}

class UserProxy implements InvocationHandler {
    private UserTransaction trx;
    private UserService us;

    public UserProxy(UserTransaction trx, UserService us) {
        this.trx = trx;
        this.us = us;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        trx.before();
        Object invoke = method.invoke(us, args);
        trx.after();
        return invoke;
    }

    public UserService getInstance() {
        return (UserService) Proxy.newProxyInstance(us.getClass().getClassLoader(), us.getClass().getInterfaces(), this);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        UserService instance = new UserProxy(new UserTransaction(), new UserServiceImpl()).getInstance();
        System.out.println(instance.getClass().getName());
        instance.add();
    }
}
