package ch12;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private final String wsUri;
	private static final File INDEX;

	static {
		URL location = HttpRequestHandler.class
			.getProtectionDomain()
			.getCodeSource().getLocation();
		try {
			String path = location.toURI() + "index.html";
			path = !path.contains("file:") ? path : path.substring(5);
			INDEX = new File(path);
		} catch (URISyntaxException e) {
			throw new IllegalStateException("Unable to locate index.html", e);
		}
	}

	public HttpRequestHandler (String wsUri) {
		this.wsUri = wsUri;
	}

	@Override
	public void channelRead (ChannelHandlerContext ctx, Object msg) throws Exception {
		super.channelRead(ctx, msg);
		// 웹 소켓 업그레이드 로직 및 구현 로직
	}

	@Override
	protected void messageReceived (ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
	}



}
