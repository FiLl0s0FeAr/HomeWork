package calculator;

import org.fest.assertions.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CalculatorSteps {

    private Calculator c;

    @Given("a calculator I just turned on")
    public void givenACalculatorIJustTurnedOn() {
        c = new Calculator();
    }

    @When("I add $val")
    public void whenIAdd(long val) {
        c.add(val);
    }

    @Then("the result is $val")
    public void thenTheResultIs(long val) {
        Assertions.assertThat(c.getState()).isEqualTo(val);
    }
}
