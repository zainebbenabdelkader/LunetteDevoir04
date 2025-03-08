package com.zaineb.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zaineb.dao.ILunetteDao;
import com.zaineb.dao.ILunetteDaoImpl;
import com.zaineb.entities.Lunette;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {

    ILunetteDao store;

    @Override
    public void init() throws ServletException {
        store = new ILunetteDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("lunettes.jsp").forward(request, response);
        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            LunetteModele model = new LunetteModele();
            model.setMotCle(motCle);
            List<Lunette> lun = store.lunettesParMC(motCle);
            model.setLunettes(lun);
            request.setAttribute("model", model);
            request.getRequestDispatcher("lunettes.jsp").forward(request, response);
        } else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisieLunette.jsp").forward(request, response);
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Lunette l = store.save(new Lunette(nom, prix));
            request.setAttribute("lunette", l);
            // request.getRequestDispatcher("confirmation.jsp").forward(request,response);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            store.deleteLunette(id);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Lunette l = store.getLunette(id);
            request.setAttribute("lunette", l);
            request.getRequestDispatcher("editerLunette.jsp").forward(request, response);
        } else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Lunette l = new Lunette();
            l.setIdLunette(id);
            l.setNomLunette(nom);
            l.setPrix(prix);
            store.updateLunette(l);
            request.setAttribute("lunette", l);
            // request.getRequestDispatcher("confirmation.jsp").forward(request,response);
            response.sendRedirect("chercher.do?motCle=");
        } else {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
