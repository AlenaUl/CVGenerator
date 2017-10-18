package de.codecentric.cvgenerator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Comparator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.SortTool;

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
		renderTemplate(out, "titlepage.vm");
	}
	
	public void renderProjects(OutputStream out) throws IOException {
		renderTemplate(out, "projects.vm");
	}

	public void renderSkills(OutputStream out) throws IOException {
		renderTemplate(out, "skills.vm");
	}
	
	public void renderPersonal(OutputStream out) throws IOException {
		renderTemplate(out, "personal.vm");
	}

	public void renderQualification(OutputStream out) throws IOException {
		renderTemplate(out, "qualification.vm");
	}
	
	public void renderCommunity(OutputStream out) throws IOException {
		renderTemplate(out, "community.vm");
	}
	
	public void renderCertification(OutputStream out) throws IOException {
		renderTemplate(out, "certification.vm");
	}
	
	private void renderTemplate(OutputStream out, String templateName) throws IOException {
		Velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		Velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		
		VelocityContext context = new VelocityContext();
		context.put("employee", employee);
		context.put("sorter", new SortTool());
		context.put("projectComparator", new Comparator<Project>() {

			@Override
			public int compare(Project left, Project right) {
				return left.getStartDate().compareTo(right.getStartDate());
			}
			
		});
		
		Template template = Velocity.getTemplate(templateName, "UTF-8");
		
		Writer writer = new OutputStreamWriter(out);
		
		template.merge(context, writer);
		
		writer.flush();
	}
	
}
