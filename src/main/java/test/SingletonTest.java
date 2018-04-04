package test;

/**
 * @author xieyan
 * @description
 * @date 2018/1/16.
 */
public class SingletonTest {
    private SingletonTest(){

    }
    private static class InnerClass{
        private final static SingletonTest singletonTest = new SingletonTest();
    }
    public static SingletonTest getInstance(){
        return InnerClass.singletonTest;
    }
}
