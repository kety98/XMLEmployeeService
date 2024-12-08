package com.kemoraes.demo.resources;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kemoraes.demo.entities.Employee;
import com.kemoraes.demo.entities.EmployeesWrapper;
import com.kemoraes.demo.entities.Project;
import com.kemoraes.demo.entities.ProjectsWrapper;
import com.kemoraes.demo.services.EmployeeService;
import com.kemoraes.demo.services.ProjectService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

@RestController
@RequestMapping(value = "/export")
public class EmployeeProjectZipResource {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;
    
    @GetMapping
    public void exportDetailsToZip(HttpServletResponse response) throws Exception {
        CompletableFuture<List<Employee>> employeesFuture = CompletableFuture.supplyAsync(() -> employeeService.findAll());
        CompletableFuture<List<Project>> projectsFuture = CompletableFuture.supplyAsync(() -> projectService.findAll());

        CompletableFuture.allOf(employeesFuture, projectsFuture).join();

        List<Employee> employees = employeesFuture.get();
        List<Project> projects = projectsFuture.get();

        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=details.zip");

        try (ZipOutputStream zipOut = new ZipOutputStream(response.getOutputStream())) {
            zipOut.putNextEntry(new ZipEntry("employees.xml"));
            JAXBContext employeeContext = JAXBContext.newInstance(EmployeesWrapper.class);
            Marshaller employeeMarshaller = employeeContext.createMarshaller();
            employeeMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            employeeMarshaller.marshal(new EmployeesWrapper(employees), zipOut);
            zipOut.closeEntry();

            zipOut.putNextEntry(new ZipEntry("projects.xml"));
            JAXBContext projectContext = JAXBContext.newInstance(ProjectsWrapper.class);
            Marshaller projectMarshaller = projectContext.createMarshaller();
            projectMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            projectMarshaller.marshal(new ProjectsWrapper(projects), zipOut);
            zipOut.closeEntry();
        }
    }

}
