Order21_FieldTest:
    静态变量 和 实例变量 在内存中怎么存的.




Order22_InitTest:
    实例变量初始化的3个时机: 变量赋值, 非静态代码块, 构造器

Order22_JavapToolTest:
    只是说到javap

Order22_StaticInitTest:
    类变量初始化的2个时机: 变量赋值, 静态代码块

Order22_PriceTest:
    初始化顺序(包括静态变量和成员变量), 特别是静态变量里有new的情况

![Order22_PriceTest_静态变量已经分配内存空间了](chapter02_readme.assets/Order22_PriceTest_静态变量已经分配内存空间了.png)





Order23_FieldAndMethodTest : 
    父子继承时
        内存控制: new子类时, 子类对象里面有2个count(实例变量);

​		![Order23_ThisTest_对象里面2个同名变量](chapter02_readme.assets/Order23_ThisTest_对象里面2个同名变量.png)

​        调用成员变量和调用方法的区别: 
​            调用成员变量是根据申明时的类型来决定调用哪个类;
​            调用方法是根据实际类型来决定调用哪个类;
Order23_ThisTest:
​    父子继承时
​        调用成员变量和调用方法的区别: 
​            this也是和上面一样的规则;
​            this.getClass(), 获取到的是实际运行时的对象类型
​        初始化顺序:
​            先父子的内存空间分配, 再父类(变量赋值, 非静态代码块, 构造器), 再子类(变量赋值, 非静态代码块, 构造器)
​            默认调用父类的无参构造器;
​        
​        
Order23_SuperTest:
​    super的作用:
​        调用(最近的)父类的方法或变量(和this或者普通引用不一样(需要看声明时类型和实际类型)), 而且很简单的, 看他extends哪个类, 就会调那个类的方法
​        其实就1个对象, super并不是指向父对象(因为就1个对象, 只不过这个变量里有3个count变量罢了)

Order23_SuperTest02:
    super的作用:
         注意, 是不允许直接用 return super;这样的语句的.
         super不能被当作一个引用变量(this就可以), 它只是一个关键字(用法也就那几种)!!
        
        
Order24_FinalTest:
    final修饰的变量必须要赋初始值(直接赋值, 代码块, 构造器, 这三种方式都可以(编译为class后, 这三种都会挪到构造器中)), 不然编译不通过.
    这个例子是成员变量;
    
Order24_FinalTest2:
    类变量也是一样!
    
