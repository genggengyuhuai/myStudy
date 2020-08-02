package spring_study.spring_bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lihaoyu
 * @date 2019/12/21 11:49
 */
@Component
public class BeanA implements InitializingBean {

    @Autowired
    private BeanB beanB;


    public BeanA(){
        System.out.println("这是 Bean A 的构造函数");
    }

    @PostConstruct
    private void init() {
        System.out.println("这是Bean A 的 init 函数");
//        beanB.testB();
    }

    void testA() {
        System.out.println("这是Bean A 的 test 方法");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init 接口的方法");
    }
}
