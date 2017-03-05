/**
 * @author Vinayak More
 *
 * @date 19-Jan-2017
 */
package main.java.deepCopy;

import java.util.ArrayList;
import java.util.List;

import main.java.bean.MyCloneable;
import main.java.bean.TestBean;

public class DeepCopy {

    public static void main(String[] args) {
        List<TestBean> list=new ArrayList<>();
        list.add(new TestBean("String 1"));
        list.add(new TestBean("String 2"));
        System.out.println("Original List\nList1=>"+list);
        List<TestBean> copyList=getDeepCopy(list);
        copyList.get(0).setStr("String 3");
        System.out.println("\nCopy List\nList2=>"+copyList);
        System.out.println("\nOrigin List after copy\nList1=>"+list);
    }

    @SuppressWarnings("unchecked")
    private static <T extends MyCloneable> List<T> getDeepCopy(List<T> originalList) {
        List<T> copy = new ArrayList<T>(originalList.size());

        for (T foo: originalList) {
          copy.add((T)foo.clone());
        }        
        return copy;
    }

}
