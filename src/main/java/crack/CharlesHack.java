package crack;

import javassist.*;

import java.io.IOException;

public class CharlesHack {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException {

        ClassPool classPool = ClassPool.getDefault();
        CtClass c = classPool.get("com.xk72.charles.gui.P");
        CtMethod m = c.getDeclaredMethod("a", new CtClass[] {});
        m.setBody("{ return true; }");
//        c.writeFile();

        CtMethod mm = c.getDeclaredMethod("a", new CtClass[] { classPool.get(String.class.getName()), classPool.get(String.class.getName()) });
        mm.setBody("{ return null; }");

        CtMethod mmm = c.getDeclaredMethod("c", new CtClass[] {});
        mmm.setBody("{ return null; }");

        c.writeFile();

    }
}
