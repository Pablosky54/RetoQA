package co.qvision.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidatePrice implements Question<Boolean> {
	
	 
	private Target pricePage;
	

	public ValidatePrice(Target pricePage){
        this.pricePage = pricePage;
	}

	@Override
    public Boolean answeredBy(Actor actor) {    	
       
		float price = Serenity.sessionVariableCalled("pagePrice");		
		String var = pricePage.resolveFor(actor).getText().replace("$","");
		float totalPrice= Float.parseFloat(var);		
		
        return price==totalPrice;
    }

    public static ValidatePrice is(Target pricePage){
        return new ValidatePrice(pricePage);
    }
}