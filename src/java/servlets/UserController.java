/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Book;
import entity.Reader;
import entity.User;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.BookFacade;
import session.ReaderFacade;
import session.UserFacade;

/**
 *
 * @author Melnikov
 */
@WebServlet(name = "UserController", urlPatterns = {
    "/showCreateBook",
    "/createBook",
    "/showListBooks",
    
    "/showListReaders",
    
})
public class UserController extends HttpServlet {
    @EJB private BookFacade bookFacade;
    @EJB private ReaderFacade readerFacade;
    @EJB private UserFacade userFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null){
            request.setAttribute("info", "У вас нет прав, войдите или зарегистрируйтесь");
            request.getRequestDispatcher("/showLogin.jsp")
                        .forward(request, response);
        }
        User user = null;
        user = (User) session.getAttribute("user");
        if(user == null){
            request.setAttribute("info", "У вас нет прав, войдите или зарегистрируйтесь");
            request.getRequestDispatcher("/showLogin.jsp")
                        .forward(request, response);
        }
        String path = request.getServletPath();
        switch (path) {
            case "/showCreateBook":
                request.getRequestDispatcher("/showCreateBook.jsp")
                        .forward(request, response);
                break;
            case "/createBook":
                String name = request.getParameter("name");
                String author = request.getParameter("author");
                String publishedYear = request.getParameter("publishedYear");
                String isbn = request.getParameter("isbn");
                if(name == null || author == null || publishedYear == null || isbn == null){
                    request.setAttribute("info", "Некорректные данные!");
                    request.getRequestDispatcher("/showCreateBook")
                        .forward(request, response);
                    break; 
                }
                Book book = new Book(name, author, Integer.parseInt(publishedYear), isbn);
                bookFacade.create(book);
                request.setAttribute("info", "Создана книга: "+book.toString());
                request.getRequestDispatcher("/index.jsp")
                        .forward(request, response);
                break;
            
            case "/showListBooks":    
                List<Book> listBooks = bookFacade.findAll();
                request.setAttribute("listBooks", listBooks);
                request.getRequestDispatcher("/showListBooks.jsp")
                        .forward(request, response);
                break;
            
            case "/showListReaders":    
                List<Reader> listReaders = readerFacade.findAll();
                request.setAttribute("listReaders", listReaders);
                request.getRequestDispatcher("/showListReaders.jsp")
                        .forward(request, response);
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
