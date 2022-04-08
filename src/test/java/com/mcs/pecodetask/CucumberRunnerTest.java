package com.mcs.pecodetask;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;

@SpringBootTest
@CucumberOptions(
        glue = {"com.mcs.pecodetask.steps"},
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json", "pretty"})
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
