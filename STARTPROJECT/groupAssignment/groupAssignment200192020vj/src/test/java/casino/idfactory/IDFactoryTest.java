package casino.idfactory;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
@RunWith(JUnitParamsRunner.class)

public class IDFactoryTest {

    private static final Object[] FactoryGeneralIdTypes() {
        return new Object[] {
                new Object[] {"bet",new BetID()},
                new Object[] {"round",new BettingRoundID()},
                new Object[] {"machine",new GamingMachineID()},
                new Object[] {"card",new CardID()}
        };
    }

    @Test
    @Parameters(method = "FactoryGeneralIdTypes")
    public void Factory_Is_Creating_Wanted_General_ID(String types,Object classType)
    {
        //arrange
        IDFactory factory = new IDFactory();
        //act
        GeneralID subclass = factory.CreateID(types);
        //assert
        assertThat(subclass, instanceOf(GeneralID.class));
        assertThat(subclass, instanceOf(classType.getClass())); // returns type Generic ID
    }
}