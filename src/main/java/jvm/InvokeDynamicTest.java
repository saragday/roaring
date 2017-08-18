package jvm;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.*;

public class InvokeDynamicTest {

    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("my test");
    }

    public static void testMethod(String str) {
        System.out.println("Hello world: " + str);
    }

    private static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name,
                                            MethodType mt) throws NoSuchMethodException, IllegalAccessException {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    private static MethodType MT_BootstrapMethod() {
        return MethodType.fromMethodDescriptorString("(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                                                     null);
    }

    private static MethodHandle MH_MethodHandle() throws NoSuchMethodException, IllegalAccessException {
        return lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite callSite = (CallSite) MH_MethodHandle().invokeWithArguments(lookup(), "testMethod",
                                                                             MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V",
                                                                                                                   null));
        return callSite.dynamicInvoker();
    }
}
