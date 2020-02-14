package wizut.tpsi.ogloszenia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wizut.tpsi.ogloszenia.services.OffersService;

@SpringBootApplication
public class OgloszeniaApplication {
        
	public static void main(String[] args) {
		SpringApplication.run(OgloszeniaApplication.class, args);
                
        }
        
}
