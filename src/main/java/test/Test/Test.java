package test.Test;


import test.domain.PageInfo;
import test.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/12/4.
 */
public class Test {

    public static void main(String[] args) {
        /*Lock lock = new ReentrantLock();
        lock.lock();

        lock.unlock();

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
        user.setUsername("cde");
        System.out.println(((List)page.getResult()).get(0).toString());*/

        Scanner in = new Scanner(System.in);
        long res;

        int _from_size = 0;
        _from_size = Integer.parseInt(in.nextLine().trim());
        int[] _from = new int[_from_size];
        int _from_item;
        for(int _from_i = 0; _from_i < _from_size; _from_i++) {
            _from_item = Integer.parseInt(in.nextLine().trim());
            _from[_from_i] = _from_item;
        }

        int _to_size = 0;
        _to_size = Integer.parseInt(in.nextLine().trim());
        int[] _to = new int[_to_size];
        int _to_item;
        for(int _to_i = 0; _to_i < _to_size; _to_i++) {
            _to_item = Integer.parseInt(in.nextLine().trim());
            _to[_to_i] = _to_item;
        }

        res = min(_from, _to);
        System.out.println(String.valueOf(res));
    }
    public static long min(int[] from,int[] to){
        Arrays.sort(from);
        Arrays.sort(to);
        int length1 = from.length;
        int length2 = to.length;
        long temp = 0;
        int length = length1 > length2 ? length2 : length1;
        for(int i = 0;i < length;i++){
            temp += to[i] * from[i];
        }
        if(length1 > length2){
            for(int j = length ;j < length1 ;j ++){
                temp += from[j]*from[j+1];
                j++;
            }
        }else{
            for(int j = length ;j < length2 ;j ++){
                temp += to[j]*to[j+1];
                j++;
            }
        }
        return temp;
    }
}
