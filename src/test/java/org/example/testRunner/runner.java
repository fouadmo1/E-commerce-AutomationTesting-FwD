package org.example.testRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions
        (
                features = "E:\\Mvencucamber\\src\\main\\resources\\Features",
                glue={"org/example/stepDef"},
                plugin = { "pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cucumber.cukes.xml",
                        "rerun:target/cucumber.rerun.txt"

                },
                tags= "@smoke"
        )
public class runner extends AbstractTestNGCucumberTests {
}