package design_pattern.prototype;

/**
 * 原型模式，复制对象，从缓冲池中取个对象然后复制返回
 * 就是Java 的 clone
 *
 * @author lihaoyu
 * @date 2019/12/5 19:29
 */

class Attachment{
    String url;
}

class Email implements Cloneable{
    String title;
    Attachment attachment;

    @Override
    protected Object clone() {
        Email email = new Email();
        email.title = this.title;
        return email;
    }
}


public class PrototypeTest {

    public static void main(String[] args)  {



    }

}
