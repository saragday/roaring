package jvm.proxy;

public class HelloWorldPrintImpl implements HelloWorldPrint {
    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}
