package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NoCacheFilter implements Filter {

	private String resourcesList;
	private String patternType;

	public NoCacheFilter() {
		if (this.resourcesList == null) {
			resourcesList = "js=src, css=href";
		}
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		res.setCharacterEncoding(req.getCharacterEncoding());
		PrintWriter out = res.getWriter();
		ResponseContent myResponse = new ResponseContent((HttpServletResponse) res);
		chain.doFilter(req, myResponse);

		ParseContent parseContent = ParseContent.getInstance();
		String content = myResponse.toString();

		if (!this.patternType.equals("disabled"))
			content = parseContent.setNoCache(content, this.resourcesList, this.patternType);

		out.write(content);
		out.flush();
		out.close();
	}

	public void init(FilterConfig arg0) {
	}

	public String getResourcesList() {
		return resourcesList;
	}

	public void setResourcesList(String resourcesList) {
		this.resourcesList = resourcesList;
	}

	public String getPatternType() {
		return patternType;
	}

	public void setPatternType(String patternType) {
		this.patternType = patternType;
	}
}