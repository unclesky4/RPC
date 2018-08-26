package org.unclesky4.rpc.common;

/**
 * @ClassName: RpcResponse 
 * @Description: 封装RPC响应
 * @author: unclesky4
 * @date: Aug 26, 2018 2:27:53 PM
 */
public class RpcResponse {

	private String requestId;
	private Throwable error;
	private Object result;

	public boolean isError() {
		return error != null;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Throwable getError() {
		return error;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
