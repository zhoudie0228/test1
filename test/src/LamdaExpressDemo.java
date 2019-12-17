
@FunctionalInterface
interface Foo{
    //public void sayHello();

    public int add(int x,int y);

    default int div(int x,int y)
    {
        return x/y;
    }
    static int mul(int x,int y){
        return x*y;
    }
}




public class LamdaExpressDemo {
    public static void main(String[] args) {
       /*Foo foo=new Foo() {
           @Override
           public void sayHello() {
               System.out.println("******hello 0805");
           }
       };
       foo.sayHello();

       Foo foo2=()->{
           System.out.println("*8*hello LamdaExpress");
       };
       foo2.sayHello();*/

        Foo foo = (x, y) -> {
            System.out.println("***come in add method");
            return x + y;
        };
        System.out.println(foo.add(3, 35));
        System.out.println(foo.div(10, 2));
        System.out.println(Foo.mul(2, 3));
    }
}
