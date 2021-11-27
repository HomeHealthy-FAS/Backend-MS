package pe.edu.upc.socialservice.unit;

import org.junit.jupiter.api.Test;
import pe.edu.upc.socialservice.entity.Collaborator;
import pe.edu.upc.socialservice.entity.Customer;

import static org.assertj.core.api.Assertions.assertThat;

public class CollaboratorUnitTest {

    @Test
    public void createCollaboratorWithValidEmail(){

        Collaborator collaborator = new Collaborator();
        String email = "testEmail@gmail.com";
        collaborator.setEmail(email);

        assertThat(collaborator.getEmail()).isEqualTo(email);
    }

    @Test
    public void createCollaboratorWithValidUsername(){

        Collaborator collaborator = new Collaborator();
        String username = "testUsername";
        collaborator.setUsername(username);

        assertThat(collaborator.getUsername()).isEqualTo(username);
    }

    @Test
    public void createCollaboratorWithValidPassword(){

        Collaborator collaborator = new Collaborator();
        String password = "testpasword123";
        collaborator.setPassword(password);

        assertThat(collaborator.getPassword()).isEqualTo(password);
    }

    @Test
    public void createCollaboratorWithValidPhonenumber(){

        Collaborator collaborator = new Collaborator();
        Long phone = 98769876L;
        collaborator.setPhone(phone);

        assertThat(collaborator.getPhone()).isEqualTo(phone);
    }

    @Test
    public void createCollaboratorWithValidStatus(){

        Collaborator collaborator = new Collaborator();
        String status = "CREATED";
        collaborator.setStatus(status);

        assertThat(collaborator.getStatus()).isEqualTo(status);
    }

    @Test
    public void createCollaboratorWithValidAddress(){

        Collaborator collaborator = new Collaborator();
        String address = "Fake street 123";
        collaborator.setAddress(address);

        assertThat(collaborator.getAddress()).isEqualTo(address);
    }
}
