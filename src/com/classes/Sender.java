package com.classes;

import com.classes.serverSide.answers.Request;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class Sender {
    private DatagramChannel datagramChannel;
    private SocketAddress socketAddress;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(16384);


    public Sender(DatagramChannel channel, SocketAddress serverAddress){
        this.datagramChannel = channel;
        this.socketAddress = serverAddress;
    }

    public void send(Request request){
        try {
            System.out.println("Попытка отправить сообщение.");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(request);
            byteBuffer.put(byteArrayOutputStream.toByteArray());
            objectOutputStream.flush();
            byteArrayOutputStream.flush();
            byteBuffer.flip();
            datagramChannel.send(byteBuffer, socketAddress);
            System.out.println("Сообщение отправлено.");
            objectOutputStream.close();
            byteArrayOutputStream.close();
            byteBuffer.clear();
        } catch (IOException e) {
            System.out.println("Сообщение не отправлено.");
            e.printStackTrace();
        }
    }

}
