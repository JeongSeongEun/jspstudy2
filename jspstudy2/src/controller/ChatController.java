package controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/chatting") //웹소켓의 서버클래스. /chatting 접속시
public class ChatController {
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        synchronized (clients) {
            for (Session client : clients) {
                if(!client.equals(session)) {
                    client.getBasicRemote().sendText(message);
                }
            }
        }
    }
    @OnOpen //client 접속시
    public void onOpen(Session session) {
        clients.add(session);
    }
    @OnClose //client접속 종료시
    public void onClose(Session session) {
        clients.remove(session);
    }
}