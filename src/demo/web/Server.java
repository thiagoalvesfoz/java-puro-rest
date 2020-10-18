package demo.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.net.httpserver.HttpServer;

public class Server {
	
	private final static int PORT = 8080;
	
	public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", PORT), 0);
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(10);
            server.createContext("/usuarios", new UsuarioHttpHandler());
            server.setExecutor(threadPoolExecutor);
            server.start();
            Logger.getLogger(" Server started on port " + PORT + ".");

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
