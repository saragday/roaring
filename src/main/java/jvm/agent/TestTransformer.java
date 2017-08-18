package jvm.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class TestTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
//        ClassReader cr = new ClassReader(classfileBuffer);
//        ClassNode cn = new ClassNode();
//        cr.accept(cn, 0);
//        for (Object obj : cn.methods) {
//            MethodNode md = (MethodNode) obj;
//            if ("<init>".endsWith(md.name) || "<clinit>".equals(md.name)) {
//                continue;
//            }
//            InsnList insnList = md.instructions;
//            InsnList il = new InsnList();
//            il.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out",
//                    "Ljava/io/PrintStream;"));
//            il.add(new LdcInsnNode("Enter method-> " + cn.name + "." + md.name));
//            il.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io.PrintStream",
//                    "println", "(Ljava/lang/String;)V", false));
//            insnList.insert(il);
//            md.maxStack += 3;
//        }
//        ClassWriter cw = new ClassWriter(0);
//        cn.accept(cw);
//        return cw.toByteArray();
        return null;
    }
}
