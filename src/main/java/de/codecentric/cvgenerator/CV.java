package de.codecentric.cvgenerator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class CV {
	
	private Employee employee;
	
	public CV(Employee employee) {
		this.employee = employee;
	}
	
	/**
	 * Render this CV as PDF file.
	 * @param out
	 */
	public void renderTitlePage(OutputStream out) throws IOException {
		Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		
		VelocityContext context = new VelocityContext();
		context.put("name", employee.getFirstname() + " " + employee.getLastname());
		
		Template template = Velocity.getTemplate("titlepage.vm");
		
		Writer writer = new OutputStreamWriter(out);
		
		template.merge(context, writer);
		
		writer.flush();
	}
	
	/**
	 * Render this CV as PDF file.
	 * @param out
	 */
	public void render(OutputStream out) throws IOException {
		Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		
		VelocityContext context = new VelocityContext();
		context.put("employee", employee);
				
		Template template = Velocity.getTemplate("projects.vm");
		
		Writer writer = new OutputStreamWriter(out);
		
		template.merge(context, writer);
		
		writer.flush();
	}

}
