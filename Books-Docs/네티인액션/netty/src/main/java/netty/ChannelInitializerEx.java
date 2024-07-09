package netty;

import ch2.EchoServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ChannelInitializerEx extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel (SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast(new EchoServerHandler());
	}

}
