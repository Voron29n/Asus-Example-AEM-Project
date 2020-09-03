package com.epam.asus.core.servlets;

import org.apache.commons.io.FilenameUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.jetbrains.annotations.NotNull;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;


@Component(service=Servlet.class,
        property={
                Constants.SERVICE_DESCRIPTION + "= Servlet style",
//                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
//                "sling.servlet.resourceTypes=" + "sling/servlet/default",
////                "sling.servlet.resourceTypes=" + "sling/servlet/default",
//                "sling.servlet.selectors=" + "asus",
////                "sling.servlet.paths="+ "myDataSourcePoolServlet/css",
////             "sling.servlet.paths.strict = true",
////                "sling.servlet.prefix="+ "/bin/",
////                "sling.servlet.paths="+ "myDataSourcePoolServlet/css/",
//                "sling.servlet.extensions=" + "css"

                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.resourceTypes="+ "sling/servlet/default",
                "sling.servlet.selectors="+ "asus",
                "sling.servlet.extensions="+ "css"
        })
public class StyleCmpServlet extends SlingSafeMethodsServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private static final String PATH_REQUEST = "/bin/myDataSourcePoolServlet/css/(.*)";
    private static final String PATH_CSS_NODE = "/apps/asus/clientlibs/clientlib-dependencies/css";

    @Override
    protected void doGet(final SlingHttpServletRequest request, final @NotNull SlingHttpServletResponse response) throws IOException {

        if(request.getPathInfo().matches(PATH_REQUEST)){
            String name = Path.of(FilenameUtils.getName(request.getPathInfo())).getFileName().toString();

            Resource resource = request.getResourceResolver().getResource(PATH_CSS_NODE);
            Resource child = null;
            if (resource != null) {
                child = resource.getChild(name);
                response.setContentType("text/css");
                response.getOutputStream().write(Objects.requireNonNull(child).getPath().getBytes().clone());
            }
        }
    }
}
