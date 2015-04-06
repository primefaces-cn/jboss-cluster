package com.avnet.test;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quickstarts.ServiceAccess;
import quickstarts.ServiceAccessBean;

@WebServlet("/CluserServlet")
public class CluserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// @EJB
	ServiceAccessBean ss;

	public CluserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		SingletonServiceClient();
		System.out.println("-----------node name:  "
				+ accessBean.getNodeNameOfTimerService());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	private ServiceAccess accessBean;

	/**
	 * Constructor to prepare the client-context.<br/>
	 * There must be a jboss-ejb-client.properties file in the classpath to
	 * specify the server connection(s).
	 * 
	 * @throws NamingException
	 */
	public void SingletonServiceClient() {
		try {
			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES,
					"org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			String lookupName = "ejb:/ClusterEar/cluster-ejb/ServiceAccessBean!"
					+ ServiceAccess.class.getName();
			System.out
					.println("------------Lookup Bean name is: " + lookupName);
			accessBean = (ServiceAccess) context.lookup(lookupName);
		} catch (Exception e) {
			System.out.println("============SingletonServiceClient error: "
					+ e.getLocalizedMessage());
		}
	}
}
