package com.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

public class ResponseContent extends HttpServletResponseWrapper {
	private CharArrayWriter buffer;
	private PrintWriter printWriter;

	protected ResponseContent(HttpServletResponse response) {
		super(response);
		buffer = new CharArrayWriter();
		response.reset();
	}

	public PrintWriter getWriter() {
		if (printWriter == null)
			printWriter = new PrintWriter(buffer);
		return printWriter;
	}

	public String toString() {
		return buffer.toString();
	}
}