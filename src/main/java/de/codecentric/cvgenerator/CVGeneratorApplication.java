package de.codecentric.cvgenerator;

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
			
		ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("/home/alena/files.zip"));
			
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
		
		//System.out.println("Employee: " + emp.toString());
	//}	
		
		
	}
}
