package deti.tqs.phihub.defaults;

import org.springframework.boot.ApplicationRunner;

import deti.tqs.phihub.configs.Generated;
import deti.tqs.phihub.models.Staff;
import deti.tqs.phihub.repositories.StaffRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Value;

@Component
@Generated
public class StaffUsers implements ApplicationRunner {

    @Value("${staff.aguiar.pass}")
    private String aguiarPass;

    StaffRepository staffRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public StaffUsers(StaffRepository staffRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.staffRepository = staffRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (staffRepository.count() > 0) {
            return;
        }

        Staff aguiar = new Staff();
        aguiar.setUsername("aguiar");
        aguiar.setPassword(bCryptPasswordEncoder.encode(aguiarPass));
        aguiar.setAge(20);
        aguiar.setEmail("aguiar@gmail.com");
        aguiar.setName("Aguiar");
        aguiar.setId(1L);
        aguiar.setPhone("9877654321");

        staffRepository.save(aguiar);

    }

}
