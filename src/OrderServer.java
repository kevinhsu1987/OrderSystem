import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class OrderServer {
    HttpServer server;
    OrderServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/index", new HomeHandler());
    }

    void Start(){
        server.start();
    }

    void Stop(){
        server.stop(0);
    }
    static class HomeHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "hello world";
            httpExchange.sendResponseHeaders(200, 0);
            OutputStream os = httpExchange.getResponseBody();
            os.write((response.getBytes()));
            os.close();
        }
    }
    void PrintOrder(String items) {
        System.out.println("You ordered: " + items);
    }

    public static void main(String[] args) {
        try {
            OrderServer orderServer = new OrderServer();
            orderServer.Start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
