package ar.edu.uces.progweb2.booksmov.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InjectedDependencyFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		if(req.getSession().getAttribute("user") != null && !uri.contains("login")){
			System.out.println("In InjectedDependencyFilter");
			chain.doFilter(req, res);
		}else{
			res.sendRedirect("/booksmov/");
		}
	}

	@Override
	public void destroy() {
	}

}
