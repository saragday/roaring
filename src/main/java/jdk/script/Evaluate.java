package jdk.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Evaluate {

    public static void main(String[] args) {
        ScriptEngine js = new ScriptEngineManager().getEngineByName("JavaScript");
        Object ss = null;
        try {
            ss = js.eval("function() { var jh = [];" + "jh[0] = 1;" + "return jh;}");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.printf(String.valueOf(ss));
    }

}
