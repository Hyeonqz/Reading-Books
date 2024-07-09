package eventloop;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class EventLoop implements Runnable{

	private final ServerSocketChannel socketChannel;
	private final Selector selector;

	public EventLoop (int port) throws IOException {
		this.socketChannel = ServerSocketChannel.open();
		this.socketChannel.bind(new InetSocketAddress(port));
		this.socketChannel.configureBlocking(false);
		this.selector = Selector.open();

		// ServerSocketChannel 은 새로운 커넥션을 받아들이는 역할을 한다. 따라서 OP_ACCEPT 를 등록한ㄷ,
		SelectionKey selectionKey = this.socketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
		// ServerSocketChannel 에 대한 이벤트는 새로운 커넥션에 대한 이벤트기에 ServerSocketChannel 엔
		// 새로운 커넥션이 오면 처리해야 하는 Handler 를 등록해준다.
		selectionKey.attach(new ConnectionAcceptHandler(socketChannel, selector));
	}

	@Override
	public void run () {
		// I/O 이벤트가 발생할 때까지 대기하다가 이벤트가 발생하면 처리할 수 있는 핸들러에게 dispatch 한다.
		try {
			while(true) {
				selector.select();
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				for(SelectionKey key : selectedKeys) {
					dispatch(key);
				}
				selectedKeys.clear();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void dispatch (SelectionKey key) {
		Handler handler = (Handler) key.attachment();
		handler.handle();
	}

}
