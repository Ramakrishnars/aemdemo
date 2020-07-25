/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.core.been.Employ;
import com.aem.core.services.EmployeeI;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=Employee Register Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                    "sling.servlet.paths="+ "/bin/employreg"
           })
public class EmployeeRegisterServlet extends SlingAllMethodsServlet {

	private static final Logger log=LoggerFactory.getLogger(EmployeeRegisterServlet.class);
    private static final long serialVersionUid = 1L;

    @Reference 
	private EmployeeI emps;
    /*@Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
        final Resource resource = req.getResource();
        resp.setContentType("text/plain");
        resp.getWriter().write("Title = " + resource.adaptTo(ValueMap.class).get("jcr:title"));
    }*/
    
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	//super.doPost(request, response);
    	
    	String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String empsal=request.getParameter("empsal");
		String empaddr=request.getParameter("empaddr");
		
		log.info("Employee Id:"+empid);
		log.info("Employee Name:"+empname);
		log.info("Employee Salary:"+empsal);
		log.info("Employee Address:"+empaddr);
		
		try {
			Employ emp=new Employ();
			emp.setEmpId(empid);
			emp.setEmpName(empname);
			emp.setEmpSal(empsal);
			emp.setEmpAddr(empaddr);
			boolean b=emps.addEmployee(emp);
			if(b){
				log.info("record inserted successfully");
			}else
			{
				log.info("record not inserted successfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		}
    }

