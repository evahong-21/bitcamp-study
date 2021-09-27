package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serverApp {
  public static void main(String[] args) throws IOException {
    System.out.println("server");

    System.out.println("1) 서버소캣준비");
    ServerSocket serverSocket = new ServerSocket(8888);

    System.out.println("2) 클라이언트의 접속을 기다림");
    Socket socket = serverSocket.accept();

    System.out.println("3) 클라이언트가 접속했음");

    System.out.println("클라이언트와 데이터를 주고받기 위해 입출력 스트림 준비");
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    PrintWriter out = new PrintWriter(socket.getOutputStream());

    System.out.println("클라이언트에게 데이터 보내기");
    out.println("안녕");
    //데이터를 확실하게 보내고 싶으면 flush를 명시하자. close에 의존하지 말자
    out.flush();

    String message = in.readLine();
    System.out.println("===> "+message);
    System.out.println("4) 클라이언트와의 접속을 끊음");
    out.close();
    in.close();
    socket.close();

    System.out.println("5) 서버 소켓 종료");
    serverSocket.close();
  }
}
