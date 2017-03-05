/**
 * @author Vinayak More
 *
 * @date 19-Jan-2017
 */
package main.java.bean;

public class TestBean implements MyCloneable{
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    /**
     * @param str
     */
    public TestBean(String str) {
        super();
        this.str = str;
    }

    @Override
    public String toString() {
        return "TestBean [" + str + "]";
    }

    @Override
    public Object clone() {
        String str=new String(this.str.getBytes());
        return new TestBean(str);
    }

}
