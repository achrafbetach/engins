package com.esisa.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketsApplication{

	// private final AdminRepository adminRepository;
	// private final PanneRepository panneRepository;
	// @Autowired
	// public TicketsApplication(AdminRepository adminRepository, PanneRepository panneRepository) {
	// 	this.adminRepository = adminRepository;
	// 	this.panneRepository = panneRepository;
	// }

	public TicketsApplication(){

	}

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	if (adminRepository.findAll().isEmpty()) {
	// 		adminRepository.save(new Admin("Achraf Betach", "ashrafbetach@gmail.com", "achraf123"));
	// 		adminRepository.save(new Admin("Zakaria Zejly", "zejly12@gmail.com", "zakaria123"));
			
	// 	}

	// 	for (Admin admin : adminRepository.findAll()) {
	// 		System.out.println(admin);
	// 	}
		
	// }

}
