import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Task;
import util.UtilDB;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public Servlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      if (request.getParameter("title") != null)
      {
          UtilDB.createTasks(request.getParameter("title"), request.getParameter("dueDate"), 
        		  request.getParameter("notes"), request.getParameter("complete"));
      }
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "To-do";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Task> listTasks = UtilDB.listTasks();
      for (Task task : listTasks) {
         out.println("<li>" +
               "[TITLE] " + task.getTitle()
               + " [DUE DATE] " + task.getDueDate()
               + " [NOTES] " + task.getNotes()
               + " [COMPLETE] " + task.getComplete() + "</li>");
      }
      out.println("</ul>");
      out.println("<a href=/TechExercise/insertPage.html>New Task</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
