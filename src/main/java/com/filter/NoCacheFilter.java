package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NoCacheFilter implements Filter {

	private FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		res.setCharacterEncoding(req.getCharacterEncoding());
		PrintWriter out = res.getWriter();
		ResponseContent myResponse = new ResponseContent((HttpServletResponse) res);
		chain.doFilter(req, myResponse);

		ParseContent parseContent = ParseContent.getInstance();
		String content = myResponse.toString();

		String resourcess = filterConfig.getInitParameter("resourcess");
		if(resourcess == null) {
			resourcess = "js=src, css=href";
		}
		String patternType = filterConfig.getInitParameter("patternType");
		if (patternType== null) {
			patternType = "";
		}

		if (!patternType.equals("disabled"))
			content = parseContent.setNoCache(content, resourcess, patternType);

		out.write(content);
		out.flush();
		out.close();
	}

	public void destroy() {
	}
}
