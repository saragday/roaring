package jvm.proxy;

public class Test {

    public static void main(String[] args){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        HelloWorldPrint helloWorldPrint = new HelloWorldPrintImpl();
        HelloWorldPrint helloWorldPrintProxy = (HelloWorldPrint) new PrintMyNameProxy().
                newProxy(helloWorldPrint);
        helloWorldPrintProxy.sayHello();
    }
}
