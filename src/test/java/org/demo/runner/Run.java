package org.demo.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;




@RunWith(Cucumber.class)
@CucumberOptions(
					features 	= "src/test/resources/Features",
					glue 		= "org.demo.stepdefination",
					snippets 	= SnippetType.CAMELCASE,
					dryRun 		=  false,
					tags 		= "@Register and @Sanity"
				)
public class Run {

}
