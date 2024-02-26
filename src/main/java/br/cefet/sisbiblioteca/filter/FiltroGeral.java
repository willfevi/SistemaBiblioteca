package br.cefet.sisbiblioteca.filter;

import java.io.IOException;

import br.cefet.sisbiblioteca.model.Bibliotecario;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroGeral
 */
@WebFilter("/*")
public class FiltroGeral extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroGeral() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String url = req.getRequestURI();
		
		HttpSession session = req.getSession();
		

		Bibliotecario bibliotecario = (Bibliotecario) session.getAttribute("bibliotecario");
		System.out.println(url);
			
		if (bibliotecario==null){			
		    if (url.startsWith("/sisbiblioteca/login.jsp") ||
		    		url.startsWith("/sisbiblioteca/BibliotecarioLogar"))
		    	chain.doFilter(request, response);			
		    else
		    	resp.sendRedirect("/sisbiblioteca/login.jsp");        		
		}else{			
		    chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
