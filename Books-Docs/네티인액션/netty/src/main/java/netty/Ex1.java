package netty;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.CharsetUtil;

public class Ex1 {
	public static void main (String[] args) {

		// 연결된 Channel
		Channel channel = ...;

		// Channel 을 통ㄹ해 원격지에 데이터를 보낼 때 사용될 ByteBuf
		ByteBuf buf = Unpooled.copiedBuffer("Hello World", CharsetUtil.UTF_8);

		// channel 에 BYteBuf 를 넘기고 write 과 flush 한다.
		ChannelFuture ch = channel.writeAndFlush(buf);

		// Channel 에 I/O 명령인 writeAndFlush 명령에 대한 결과 콜백 추가
		ch.addListener(new ChannelFutureListener() {

			@Override
			public void operationComplete (ChannelFuture future) throws Exception {
				if(future.isSuccess()){
					log.info("Write Successful");
					return;
				}
				log.error("Write Error");
				future.cause().printStackTrace();
			}
		});

	}
}
