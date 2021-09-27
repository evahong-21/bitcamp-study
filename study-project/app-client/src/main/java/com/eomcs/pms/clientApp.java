package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientApp {
  public static void main(String[] args) throws UnknownHostException, IOException {
    System.out.println("client");

    System.out.println("1) 소켓 준비");
    Socket socket = new Socket("127.0.0.1",8888); // 서버와 접속이 이루어지면 리턴

    System.out.println("2) 서버와 연결 되었음.");

    System.out.println("입출력 객체 준비");

    PrintWriter out = new PrintWriter(socket.getOutputStream());

    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    System.out.println("데이터보내기");
    out.println("Hello!");
    out.flush();

    System.out.println("서버가 보낸 데이터 확인");
    String result = in.readLine();
    System.out.println(">>> " + result);

    System.out.println("3) 서버와의 연결을 끊음");
    in.close();
    out.close();
    socket.close();


  }
}
