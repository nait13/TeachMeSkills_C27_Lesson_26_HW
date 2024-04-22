package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet("/load-book")
@MultipartConfig()
public class LoadBookServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LoadBookServlet.class);

    @Override
    public void init() throws ServletException {
        logger.info("initialized LoadBookServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Redirecting the request to DownloadBookServer.html");
        req.getServletContext().getRequestDispatcher("/DownloadBookServer.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException {
        try {
            Part filePart = request.getPart("file");
            System.out.println("FILE PART " + filePart.getSubmittedFileName());
            String name = filePart.getSubmittedFileName();
            filePart.write("D:\\" + name);
            response.getWriter().print("The file uploaded successfully :)");
        } catch (Exception e) {
            logger.error("Something wrong :( " + e.getStackTrace());
            response.getWriter().print("Something wrong :(");
        }
    }
}