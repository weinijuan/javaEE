package edu.whu.oo;

public class Demo {

    public static void main(String[] args) {
        Bird bird1=new Bird();
        bird1.eat();
        //将Bird对象赋值给Animal变量
        Animal bird=new Bird();
        bird.eat(); //输出：Bird正在吃虫子

        //多态
        Animal[] animals = new Animal[]{
             new Bird(),new Mouse(),new Bird(),
        };
        for(Animal animal:animals){
            animal.eat(); //根据不同的对象类型，调用不同的eat方法
        }

        //基于接口的多态
        Flyable[] flyables = new Flyable[]{
                new Bird(),new AirPlane(),new Bird(),
        };
        for(Flyable flyable:flyables){
            flyable.fly(); //根据不同的对象类型，调用不同的fly方法
        }
        for(Flyable flyable:flyables){
            startToFly(flyable); //调用方法，传入接口类型变量
        }
    }

    /**
     * 使用接口类型作为参数
     * @param flyable 可以接收说有实现Flyable接口的类的对象
     */
    public static void startToFly(Flyable flyable){
        flyable.fly();
    }
}
