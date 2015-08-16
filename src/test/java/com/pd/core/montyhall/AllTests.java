package com.pd.core.montyhall;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.pd.core.montyhall.actors.*;
import com.pd.core.montyhall.game.PlayGameTest;
import com.pd.core.montyhall.prize.BoxesHandlerTest;
import com.pd.core.montyhall.util.MontyHallUtilTest;

@RunWith(Suite.class)
@SuiteClasses({ ActorFactoryTest.class, ContestantTest.class, HostTest.class, PlayGameTest.class,
		BoxesHandlerTest.class, MontyHallUtilTest.class })
public class AllTests {

}
