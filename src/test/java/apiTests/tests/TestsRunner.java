package apiTests.tests;

import com.intuit.karate.junit5.Karate;

class TestsRunner {
    
    @Karate.Test
    Karate testAll() {
//        return Karate.run("users", "pets").relativeTo(getClass());
    	return Karate.run("users").relativeTo(getClass());
    }    

}
