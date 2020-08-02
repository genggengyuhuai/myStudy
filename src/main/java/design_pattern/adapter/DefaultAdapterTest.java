package design_pattern.adapter;


/**
 *  最简单的默认适配器是 有一个接口，他的方法很多，往往我们不想全部实现
 *  这时候需要一个 Adapter 提供所有方法的默认实现
 *  那么自己的类通过 继承  Adapter 就可以自定义实现其中的某些方法
 *
 *  JDK8 之后 接口有了 default 关键字，就不用这么写了
 * @author lihaoyu
 * @date 2/9/2020 1:50 PM
 */
interface FileAlterationListener{
   void onDirectoryCreate();
    void onDirectoryChange();
    void onDirectoryDelete();
    void onFileCreate();
    void onFileChange();
    void onFileDelete();
}

class FileAlterationListenerAdapter implements FileAlterationListener{
    @Override
    public void onDirectoryCreate() { }
    @Override
    public void onDirectoryChange() {  }
    @Override
    public void onDirectoryDelete() {  }
    @Override
    public void onFileCreate() {  }
    @Override
    public void onFileChange() { }
    @Override
    public void onFileDelete() {  }
}

public class DefaultAdapterTest {
}
