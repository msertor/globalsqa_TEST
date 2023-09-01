package com.globalsqa.steps;

import com.globalsqa.pages.AddCustomerFormPage;
import com.globalsqa.pages.CustomersSectionPage;
import com.globalsqa.pages.LoginPage;
import com.globalsqa.pages.ManagerPage;
import com.globalsqa.selenium.DriverManager;
import com.globalsqa.utils.PropertiesHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;

public class AddCustomerSteps extends DriverManager {

    public LoginPage loginPage;
    public ManagerPage managerPage;
    public AddCustomerFormPage addCustomerFormPage;
    public CustomersSectionPage customersPage;
    private static final PropertiesHelper PH = new PropertiesHelper();

    @Given("the user is logged in as Manager")
    public void theUserIsLoggedInAsManager() {
        loginPage = new LoginPage(driver);
        managerPage = loginPage.pressBankManagerLogin();
    }

    @Given("the manager is in the Add Customer section")
    public void theManagerIsInTheAddCustomerSection() {
        addCustomerFormPage = managerPage.pressAddCustomerSection();
    }

    @Given("the manager adds a new customer")
    public void theManagerAddsANewCustomer() {
        managerPage.pressAddCustomerSection();
        addCustomerFormPage = new AddCustomerFormPage(driver);
        addCustomerFormPage.fillForm(PH.getFirstName(), PH.getLastName(), PH.getPostalCode());
        addCustomerFormPage.submitForm();
        addCustomerFormPage.dismissAlert();
    }

    @When("the manager fills the form")
    public void theManagerFillsTheForm() {
        addCustomerFormPage.fillForm(PH.getFirstName(), PH.getLastName(), PH.getPostalCode());
    }

    @When("the manager submits the form")
    public void theManagerSubmitsTheForm() {
        addCustomerFormPage.submitForm();
    }

    @When("the manager goes to Customer tab")
    public void theManagerGoesToCustomerTab() {
        customersPage = addCustomerFormPage.pressCustomersSection();
    }

    @When("the manager deletes the customer under Customer tab")
    public void theManagerDeletesTheCustomerUnderCustomerTab() {
        customersPage = addCustomerFormPage.pressCustomersSection();
        customersPage.deleteCustomer(PH.getFirstName());
    }

    @Then("an alert saying that the customer has been successfully added pops up")
    public void anAlertSayingThatTheCustomerHasBeenSuccessfullyAddedPopsUp() {
        assertThat("Alert confirms that the customer is created successfully", addCustomerFormPage.checkThatAlertForCustomerAddedIsPresent());
    }

    @Then("the manager can see the new customer under Customer tab")
    public void theManagerCanSeeTheNewCustomerUnderCustomerTab() {
        customersPage.searchCustomer(PH.getFirstName());
        assertThat("Newly added customer is found", customersPage.checkIfCustomerIsFound(PH.getFirstName()));
    }

    @Then("the new customer disappears")
    public void theNewCustomerDisappears() {
        assertThat("Deleted customer dissapears from the list", !customersPage.checkIfCustomerIsFound(PH.getFirstName()));
    }
}
