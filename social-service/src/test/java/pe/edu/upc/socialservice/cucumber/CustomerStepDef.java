package pe.edu.upc.socialservice.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.socialservice.entity.Customer;
import pe.edu.upc.socialservice.repository.CustomerRepository;

public class CustomerStepDef {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer testCustomer;

    @Given("the customer insert valid attributes")
    public void theCustomerInsertValidAttributes() {
    }

    @When("the customer clicks the create button")
    public void theCustomerClicksTheCreateButton() {
    }

    @Then("a new account is created")
    public void aNewAccountIsCreated() {
    }

    @Given("the customer already has an account created")
    public void theCustomerAlreadyHasAnAccountCreated() {
    }

    @And("and the customer wants to update its information")
    public void andTheCustomerWantsToUpdateItsInformation() {
    }

    @When("the customer inserts the new information")
    public void theCustomerInsertsTheNewInformation() {
    }

    @Then("the information of its account is updated")
    public void theInformationOfItsAccountIsUpdated() {
    }

    @And("and the customer wants to delete its account")
    public void andTheCustomerWantsToDeleteItsAccount() {
    }

    @When("the customer clicks the {string} button")
    public void theCustomerClicksTheButton(String arg0) {
    }

    @Then("the account is set as {string} on the database")
    public void theAccountIsSetAsOnTheDatabase(String arg0) {
    }
}
