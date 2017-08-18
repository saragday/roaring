package performance;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

import lombok.Data;

public class SerializeBenchmark {
    public static void main(String[] args) throws IOException {
        testSerializePerform();
        testSerializeSize();
    }

    private static void testSerializeSize() throws IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.buildUserId(100).buildUserName("Star");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(userInfo);
        oos.flush();
        oos.close();
        byte[] bytes = bos.toByteArray();
        System.out.println("====JDK Serialization length : " + bytes.length);
        bos.close();

        System.out.println("=========================");

        System.out.println("===Byte array serialization length is : " + userInfo.codeC().length);
    }

    public static void testSerializePerform() throws IOException {
        UserInfo userInfo = new UserInfo();
        userInfo.buildUserId(100).buildUserName("Star");
        int loop = 1000000;
        ByteArrayOutputStream bos;
        ObjectOutputStream oos;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(userInfo);
            oos.flush();
            oos.close();
            bos.toByteArray();
            bos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The jdk serialization cost time is : " + (endTime - startTime) + " ms");
        System.out.println("=========================");


        ByteBuffer buffer = ByteBuffer.allocate(1024);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            userInfo.codeC(buffer);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The byte array serialization cost time is : " + (endTime - startTime) + " ms");
    }

    @Data
    static class UserInfo implements Serializable {
        private String userName;
        private int userId;

        UserInfo buildUserName(String name) {
            this.userName = name;
            return this;
        }

        UserInfo buildUserId(int id) {
            this.userId = id;
            return this;
        }


        byte[] codeC() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            byte[] value = this.userName.getBytes();
            buffer.putInt(value.length);
            buffer.put(value);
            buffer.putInt(this.userId);
            buffer.flip();
            byte[] result = new byte[buffer.remaining()];
            buffer.get(result);
            return result;
        }

        byte[] codeC(ByteBuffer buffer) {
            buffer.clear();
            byte[] value = this.userName.getBytes();
            buffer.putInt(value.length);
            buffer.put(value);
            buffer.putInt(this.userId);
            buffer.flip();
            byte[] result = new byte[buffer.remaining()];
            buffer.get(result);
            return result;
        }
    }


    }
