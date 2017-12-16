package org.egateway.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ServletContainer;
import io.undertow.servlet.api.ServletInfo;

public class UndertowServletTest {
	public static class MyServlet extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}

		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter writer = resp.getWriter();
			writer.write("<p style='color:red;text-align:center;'>" + this.getInitParameter("message") + "</p>");
			writer.close();
		}
	}

	public static void main(String[] args) {
		ServletInfo servletInfo = Servlets.servlet("MyServlet", MyServlet.class);
		servletInfo.addInitParam("message", "This is my first MyServlet!");
		// 绑定映射为/myServlet
		servletInfo.addMapping("/myServlet");
		DeploymentInfo deploymentInfo = Servlets.deployment();
		deploymentInfo.setClassLoader(UndertowServletTest.class.getClassLoader());
		deploymentInfo.setContextPath("/myapp");
		deploymentInfo.setDeploymentName("myServlet.war");
		deploymentInfo.addServlets(servletInfo);
		ServletContainer container = Servlets.defaultContainer();
		DeploymentManager manager = container.addDeployment(deploymentInfo);
		manager.deploy();
		/**
		 * 分发器：将用户请求分发给对应的HttpHandler
		 */
		PathHandler pathHandler = Handlers.path();
		/**
		 * servlet path处理器，DeploymentManager启动后返回的Servlet处理器。
		 */
		HttpHandler myApp = null;
		try {
			// 启动容器，生成请求处理器
			myApp = manager.start();
		} catch (ServletException e) {
			throw new RuntimeException("容器启动失败！");
		}
		// 绑定映射关系
		pathHandler.addPrefixPath("/myapp", myApp);

		Undertow server = Undertow.builder().
				// 绑定端口号和主机
				addHttpListener(8081, "localhost")
				// 设置分发处理器
				.setHandler(pathHandler).build();
		// 启动server
		server.start();
	}
}
