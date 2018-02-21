package de.codecentric.cvgenerator;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
@SuppressWarnings("deprecation")
public class CVGeneratorApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository employeeRepository;
	ProjectRepository projectRepository;
	TechnologyRepository technologyRepository;
	JobRepository jobRepository;
	PartRepository partRepository;
	CategoryRepository categoryRepository;
	CertificationRepository certificationRepository;
	CommunityRepository communityRepository;
	EmployeeCertificationRepository employeecertificationRepository;
	EmployeeCommunityRepository employeecommunityRepository;
	EmployeePublicationRepository employeepublicationRepository;
	EmployeeQualificationRepository employeequalificationRepository;
	EmployeeSkillsRepository employeeskillsRepository;
	ProjectTechnologyRepository projecttechnologyRepository;
	PublicationRepository publicationRepository;
	QualificationRepository qualificationRepository;
	SkillsRepository skillsRepository;
	SkillsCategoryRepository skillscategoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CVGeneratorApplication.class, args);
		
	}

	@Transactional
	public void run(String... arg0) throws Exception {
		Employee emp = employeeRepository.getOne(1);
		
		CVGenerator generator = new CVGenerator();

		CV cv = generator.createCV(emp);
		
		ByteArrayOutputStream templates = new ByteArrayOutputStream();
		//OutputStream templates = new FileOutputStream("/home/alena/files.zip");	
		
		ZipOutputStream zip = new ZipOutputStream(templates);
			
		zip.putNextEntry(new ZipEntry("titlepage.tex"));	
		cv.renderTitlePage(zip);	
		
		zip.putNextEntry(new ZipEntry("projects.tex"));
		cv.renderProjects(zip);
		
        zip.putNextEntry(new ZipEntry("skills.tex"));
        cv.renderSkills(zip);
		
        zip.putNextEntry(new ZipEntry("personal.tex"));
        cv.renderPersonal(zip);

        zip.putNextEntry(new ZipEntry("qualification.tex"));
        cv.renderQualification(zip);
		
        zip.putNextEntry(new ZipEntry("community.tex"));
        cv.renderCommunity(zip);

        zip.putNextEntry(new ZipEntry("certification.tex"));
        cv.renderCertification(zip);
      
        zip.close();
	
        MultipartEntity entity = new MultipartEntity();
        entity.addPart("templates", new ByteArrayBody(templates.toByteArray(), "application/zip", "tepmlates.zip"));

        HttpPost request = new HttpPost("http://localhost:8080/upload");
        request.setEntity(entity);

        @SuppressWarnings("resource")
		HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(request);
        
        System.out.println(response);

        OutputStream outputStream = new FileOutputStream("/home/alena/output.pdf");
        IOUtils.copy(response.getEntity().getContent(), outputStream);
        outputStream.close();
        
		//System.out.println("Employee: " + emp.toString());
	//}	
		
		
	}
}
