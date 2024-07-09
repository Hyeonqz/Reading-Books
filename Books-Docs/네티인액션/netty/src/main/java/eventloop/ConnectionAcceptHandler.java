package eventloop;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ConnectionAcceptHandler implements Handler{

	private final ServerSocketChannel socketChannel;
	private final Selector selector;

	public ConnectionAcceptHandler (ServerSocketChannel socketChannel, Selector selector) {
		this.socketChannel = socketChannel;
		this.selector = selector;
	}

	@Override
	public void handle () {
		try {
			SocketChannel socket = socketChannel.accept();

			if(socket != null) {
				ToUpperCaseHandler toUpperCaseHandler = new ToUpperCaseHandler(socket,selector);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
