package jvm.agent;

public class TestAgent {
    public static void main(String[] args){
        TestAgent ta = new TestAgent();
        ta.test();
    }

    private void test() {
        System.out.println("TestAgent....");
    }
}
