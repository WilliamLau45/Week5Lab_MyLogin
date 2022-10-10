/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author William Lau
 */
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        user user = (user) session.getAttribute("user");
        
        if (logout != null) {
            session.invalidate();
            request.setAttribute("message", "You have logged out. Have a great day!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
        else if(user != null) {
            response.sendRedirect("home");
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        
        }
    }
        

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session = request.getSession();

        accountService acct = new accountService();
        user loggingIn = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if (username != null || !username.equals("") || password != null || !password.equals("")) {
            loggingIn = acct.login(username, password);

            if (loggingIn != null) {
                session.setAttribute("user", loggingIn);
                response.sendRedirect("home");

            } 
            else {
                request.setAttribute("message", "Invalid Infomation, please try again");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                        .forward(request, response);
            }
        }
    }          
}
