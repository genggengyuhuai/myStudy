package spring_study.spring_bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lihaoyu
 * @date 2019/10/26 14:10
 */
@Component
public class MessageServiceImpl implements MessageService, BeanPostProcessor {

    public MessageServiceImpl()
    {
        System.out.println("message 构造函数");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("前");
//        System.out.println(bean.getClass().getName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean.getClass().getName());
        System.out.println("后");
        return bean;
    }

    @Override
    public String getMessage() {
        System.out.println("hello world");
        return "hello world";
    }



}
