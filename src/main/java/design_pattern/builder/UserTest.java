package design_pattern.builder;

/**
 * 建造者模式
 * 只调用外部类的静态变量，静态方法时，静态内部类不会被加载
 * 内部类拥有和外部类完全相同的属性
 *
 * @author lihaoyu
 * @date 2019/10/26 10:34
 */


class User {

    private String id;

    private Integer age;

    private String name;

    // 构造函数私有化
    private User(String id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {

        static {
            System.out.println("加载内部类");
        }

        private String id;

        private Integer age;

        private String name;

        public UserBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;

            return this;
        }
        public User build() {
            return new User(id, age, name);
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class UserTest {
    public static void main(String[] args) {
        User user = User.builder().id("id123").name("Francis").build();
        System.out.println(user);
    }

}