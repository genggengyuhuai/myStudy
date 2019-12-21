package spring_study.spring_bean;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lihaoyu
 * @date 2019/12/21 10:39
 */
@Component
public class BeanB implements BeanFactoryAware {

    @Autowired
    private BeanA beanA;


    @PostConstruct
    private void init() {
        System.out.println("这是BeanB 的 @PostContrust 函数");
    }

    public BeanB() {
        System.out.println("这是Bean B 的构造函数");
    }

    void testB() {
        System.out.println("这是Bean B 的 test 方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("我的工厂");
    }
}
