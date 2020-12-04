package co.qvision.stepDefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.qvision.questions.ValidatePrice;
import co.qvision.task.ComparePrice;
import co.qvision.task.OpenTheBrowser;
import co.qvision.task.PutOption;
import co.qvision.ui.HomePage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ChoseMenorPriceStepDefinition {
	
	@Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
	
	@Given("^\"([^\"]*)\" open page$")
	public void openPage(String actor){
		
		theActorCalled(actor).wasAbleTo(OpenTheBrowser.on(HomePage.newInstance()));
	    
	}


	@When("^she chose options destination, (.*) and init \"([^\"]*)\" until \"([^\"]*)\"$")
	public void sheChoseOptionsDestinationLasVegasAndInitUntil(String location,String checkIn, String checkOut){
		
		
		theActorInTheSpotlight().attemptsTo(PutOption.ofParameters(location, checkIn, checkOut)
				,ComparePrice.with(checkIn, checkOut));
	   
	}

	@Then("^she verify the total price")
	public void sheVerifyThePriceInPage(){
		
		theActorInTheSpotlight().should(seeThat(ValidatePrice.is(HomePage.PRICE)));
	   
	}

}
