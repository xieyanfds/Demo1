package test;


import test.domain.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Test1 {
    public static void main(String[] args) {
        try {

            BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor p :propertyDescriptors){
                if("pwd".equals(p.getName())){
                    User user = new User("1","1");
                    user.setPwd("123");
                    Method readMethod = p.getReadMethod();
                    Object invoke = readMethod.invoke(user);
                    System.out.println(invoke);
                }
                System.out.println(p.getName());
            }
            System.out.println(String.format("sip-router-index-%s","*"));
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
