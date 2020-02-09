package apache.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * @author lihaoyu
 * @date 2/8/2020 12:11 PM
 */
public class Test {

    static class PowerBank {
        // 剩余电量
        int remainBattery = 100;

        void doSomething(){
            System.out.print("借用前的电量为 ： " + remainBattery);
            remainBattery -= 30; // 模拟电量消耗
            System.out.println("  归还后的电量为 ： "+ remainBattery);
        }
    }

    private static class PowerBankFactory implements PooledObjectFactory<PowerBank>{
        @Override
        public PooledObject<PowerBank> makeObject() throws Exception {
            // 创建对象，因为池中都是包装类，所以放进去要包转一下
            return new DefaultPooledObject<>(new PowerBank());
        }
        @Override
        public void destroyObject(PooledObject<PowerBank> p) throws Exception {
            System.out.println("销毁一个充电宝");
        }
        @Override
        public boolean validateObject(PooledObject<PowerBank> p) {
        // 借出和归还时，以及内置后台线程检测闲置情况时，可以通过验证可以去除一些对象
        // 默认不验证，要开启则需要在PoolConfig中设置setTestOnBorrow,setTestOnReturn,setTestWhileIdle
            return p.getObject().remainBattery > 0;
        }
        @Override
        public void activateObject(PooledObject<PowerBank> p) throws Exception {
            // 在借用一个对象的时候调用，则可以在此重置其内部状态，那么返回的对象就像新的一样，例如这里重置电量
            p.getObject().remainBattery = 100;
            System.out.println("充电宝电量充满");
        }
        @Override
        public void passivateObject(PooledObject<PowerBank> p) throws Exception {
            // 对应 activateObject 方法，是在归还一个对象的时候调用，不应与activateObject方法冲突
        }
    }

    public static void main(String[] args) {
        //设置对象池的相关参数
        //新建一个对象池,传入对象工厂和配置
        GenericObjectPool<PowerBank> objectPool =
                new GenericObjectPool<>(new PowerBankFactory(), new GenericObjectPoolConfig());
        PowerBank myPowerBank = null;
        for (int i = 0; i < 10; i++) {
            try {
                //从对象池借取充电宝
                myPowerBank = objectPool.borrowObject();
                //使用该充电宝
                myPowerBank.doSomething();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (myPowerBank != null) {
                    //返还对象
                    objectPool.returnObject(myPowerBank);
                }
            }
        }
    }

}
