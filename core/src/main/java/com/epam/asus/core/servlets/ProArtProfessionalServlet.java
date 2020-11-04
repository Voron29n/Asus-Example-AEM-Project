package com.epam.asus.core.servlets;

import com.epam.asus.core.models.beans.pro_art.professional.PersonInfoBean;
import com.epam.asus.core.services.pro_art.ProArtProfessional;
import com.epam.asus.core.utilites.View;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.jetbrains.annotations.NotNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Component(service = {Servlet.class})
@SlingServletResourceTypes(
        resourceTypes = "asus/components/custom/proart/prof-list",
        methods = HttpConstants.METHOD_GET,
        extensions = "json",
        selectors = "data")
public class ProArtProfessionalServlet extends SlingSafeMethodsServlet {

    private static final String PARAM_SEARCH_PATH = "searchPath";
    private static final String PARAM_SEARCH_LIMIT = "searchLimit";

    @Reference
    private ProArtProfessional profService;

    @Override
    protected void doGet(@NotNull SlingHttpServletRequest request, @NotNull SlingHttpServletResponse response) throws ServletException, IOException {

        String searchPath = request.getParameter(PARAM_SEARCH_PATH);
        int searchLimit = Integer.parseInt(request.getParameter(PARAM_SEARCH_LIMIT));

        List<PersonInfoBean> personBeans = profService.getPersonInfoBeans(searchPath, searchLimit);

        String jsonResponse = new ObjectMapper().writerWithView(View.PersonImg.class).writeValueAsString(personBeans);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        out.print(jsonResponse);
        out.flush();
    }
}
