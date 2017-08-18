package crack;

import java.io.IOException;

import javassist.*;

public class MyCrack {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException {

        ClassPool classPool = ClassPool.getDefault();
        CtClass c = classPool.get("com.seventh7.mybatis.util.JavaUtils");
        CtMethod m = c.getDeclaredMethod("refValid");
        m.setBody("{ return true; }");
        c.writeFile();

        CtClass cc = classPool.get("com.seventh7.mybatis.service.JavaService");
        CtMethod mm = cc.getDeclaredMethod("stop");
        mm.setBody("{ return; }");
        cc.writeFile();
    }

}
