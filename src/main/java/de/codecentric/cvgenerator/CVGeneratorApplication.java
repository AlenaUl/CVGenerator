package de.codecentric.cvgenerator;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
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

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
	
/*	Employee[] employeeArray = {
				new Employee(2, "Alena", "Ulrich", "1991-01-19", "01726000000", "ulrichal20@gmail.com")
		};
		
		for (Employee employee : employeeArray){
			employeeRepository.save(employee);
		}
*/
		
		//List<Employee> listOfEmployee = employeeRepository.findAll();
		Employee emp = employeeRepository.getOne(1);
		CVGenerator generator = new CVGenerator();
		//for (Employee emp : listOfEmployee) {
			CV cv = generator.createCV(emp);
			ByteArrayOutputStream out = new ByteArrayOutputStream();		
			cv.renderProjects(out);
			
			ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("/home/alena/files.zip"));
			
			zip.putNextEntry(new ZipEntry("projects.tex"));
	        zip.write(out.toByteArray());
	        
	        ByteArrayOutputStream out2 = new ByteArrayOutputStream();		
			cv.renderTitlePage(out2);
	        
	        zip.putNextEntry(new ZipEntry("titlepage.tex"));
	        zip.write(out2.toByteArray());
	        
	        ByteArrayOutputStream out3 = new ByteArrayOutputStream();		
			cv.renderSkills(out3);
			
	        zip.putNextEntry(new ZipEntry("skills.tex"));
	        zip.write(out3.toByteArray());
	        
	        ByteArrayOutputStream out4 = new ByteArrayOutputStream();		
	        cv.renderPersonal(out4);
			
	        zip.putNextEntry(new ZipEntry("personal.tex"));
	        zip.write(out4.toByteArray());
	        
	        ByteArrayOutputStream out5 = new ByteArrayOutputStream();		
	        cv.renderQualification(out5);
			
	        zip.putNextEntry(new ZipEntry("qualification.tex"));
	        zip.write(out5.toByteArray());
	        
	        ByteArrayOutputStream out6 = new ByteArrayOutputStream();		
	        cv.renderCommunity(out6);
			
	        zip.putNextEntry(new ZipEntry("community.tex"));
	        zip.write(out6.toByteArray());
	        
	        ByteArrayOutputStream out7 = new ByteArrayOutputStream();		
	        cv.renderCertification(out7);
			
	        zip.putNextEntry(new ZipEntry("certification.tex"));
	        zip.write(out7.toByteArray());
	      
	     // zip.flush();
	        zip.close();
			
			//System.out.println("Employee: " + emp.toString());
		//}	
		
		
	}
}
