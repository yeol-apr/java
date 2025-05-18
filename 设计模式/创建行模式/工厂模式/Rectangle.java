public class Rectangle implements Shape {
    //创建实现接口的实体类
    @Override
    public void draw() {
        //@Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处:
        //1、可以当注释用,方便阅读；
        //2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，因为编译器以为这个方法是你的子类中自己增加的方法。
        System.out.println("内部矩形：：draw（）方法。");
    }
}
