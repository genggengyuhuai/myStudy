package design_pattern.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 不用实现接口的 cglib 代理
 * @author lihaoyu
 * @date 2019/11/29 20:56
 */
class HelloWorld{
    String hello;

    public HelloWorld(String hello) {
        this.hello = hello;
    }

    public void print(String world){
        System.out.println(hello+" "+world);
    }
}

class ProxyFactory implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }
}



public class HelloWorldTest {
}
