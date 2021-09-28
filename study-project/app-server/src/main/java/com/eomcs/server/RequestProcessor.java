package com.eomcs.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.eomcs.pms.table.BoardTable;
import com.eomcs.pms.table.MemberTable;
import com.google.gson.Gson;

// 역할 
// 클라이언트와 통신하는 역할.
// 클라이언트 요청이 들어오면 그 요청을 처리할 객체를 찾아 실행하는 일을 한다.
// 클라이언트 요청 정보를 객체에 보관하고, 응답 기능을 수행할 객체를 만드는 일을 함.
public class RequestProcessor implements AutoCloseable {
  Socket socket;
  PrintWriter out;
  BufferedReader in;

  BoardTable boardTable = new BoardTable();
  MemberTable memberTable = new MemberTable();

  public RequestProcessor(Socket socket) throws Exception {
    this.socket = socket;
    out = new PrintWriter(socket.getOutputStream());
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub
    try {out.close();} catch (Exception e) {}
    try {in.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}

  }

  public void service() throws Exception {
    while (true) {
      String command = in.readLine(); // 클라이언트에서 한 줄의 문자열을 보낼 때까지 기다린다.
      Request request = new Request(command, in.readLine());
      Response response = new Response();

      if (command.equalsIgnoreCase("quit")) {
        response.setStatus(Response.SUCCESS);
        response.setValue("goodBye");
        sendResult(response); // 나가야하므로 만들어줌.
        break;

      } else if (command.startsWith("/board/")) {
        boardTable.execute(request, response);

      } else if (command.startsWith("member.")) {
        memberTable.execute(request, response);

      } else {
        response.setStatus(Response.SUCCESS);
        response.setValue(command);
      }
      sendResult(response); // 클라이언트에게 클라이언트를 보냄.
    }
  }
  private void sendResult(Response response) {
    out.println(response.status);
    if (response.getValue() != null) {
      out.println(new Gson().toJson(response.getValue()));
    } else {
      out.println();
    }
    out.flush();
  }
}
