package org.unclesky4.rpc.common;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class RpcDecoder extends ByteToMessageDecoder {
	private Class<?> genericClass;

	//构造函数传入反序列化的class
	public RpcDecoder(Class<?> genericClass) {
		this.genericClass = genericClass;
	}

	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
		if (in.readableBytes() < 4){
			return;
		}
		in.markReaderIndex();
		int dataLength = in.readInt();
		if (dataLength < 0){
			channelHandlerContext.close();
		}
		if (in.readableBytes() < dataLength){
			in.resetReaderIndex();
		}
		//将ByteBuf转换为byte[]
		byte[] data = new byte[dataLength];
		in.readBytes(data);
		//将data转成object
		Object obj = SerializationUtil.deserialize(data, genericClass);
		out.add(obj);
	}

}
