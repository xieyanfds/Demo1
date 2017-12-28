package test.Test;


import test.domain.PageInfo;
import test.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public class Test {

    public static void main(String[] args) {
        PageInfo<User> page = new PageInfo<>();
        List<User> list = new ArrayList<>();
        User user = new User("1", "1");
        User user1 = new User("2","2");
        list.add(user);
        list.add(user1);
        page.setResult(list);
        page.setCurrpageNo(1);
        page.setPageSize(10);
        page.setTotalCount(20);
        page.setTotalPage(2);

    }
}
