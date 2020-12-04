package co.qvision.task;

import static co.qvision.ui.HomePage.BOTTON_SEARCH;
import static co.qvision.ui.HomePage.DATE_FINISH;
import static co.qvision.ui.HomePage.DATE_INIT;
import static co.qvision.ui.HomePage.DESTINATION;

import co.qvision.ui.HomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class PutOption implements Task {

	private String location;
	private String checkIn;
	private String checkOut;

	public PutOption(String location, String checkIn, String checkOut) {

		this.location = location;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		
		
		actor.attemptsTo(Click.on(HomePage.LOCATION),Click.on(DESTINATION.of(location).resolveFor(actor))				
				,Enter.keyValues(checkOut).into(DATE_FINISH)
				,Enter.keyValues(checkIn).into(DATE_INIT)				
				,Click.on(BOTTON_SEARCH));

	}

	public static PutOption ofParameters(String location, String checkIn, String checkOut) {

		return Tasks.instrumented(PutOption.class, location, checkIn, checkOut);
	}
	
	

}
