package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read request parameters
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		// db Operations
		try {

			UserDao udao = new UserDao();
			Connection con = udao.getMysqlConnection();
			Statement stmt = con.createStatement();

			// Query
			String sql = "select * from Student where USERNAME='" + userName + "' and PASSWORD='" + password + "'";

			ResultSet rs = stmt.executeQuery(sql);
			PrintWriter out = response.getWriter();

			while (rs.next()) {

				if (rs.getString(1).equals(userName)) {

					out.println("welcome to Home Page!!");

				} else {
					out.println("Authentication failed!!");
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void destroy() {

	}

}
