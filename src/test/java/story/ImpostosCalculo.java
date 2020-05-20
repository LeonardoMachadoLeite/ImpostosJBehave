package story;

import static java.util.Arrays.asList;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.ConfigurableEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.StoryMaps;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.reporters.ReportsCount;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.ViewGenerator;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.junit.Test;
import org.jbehave.core.reporters.Format;

import steps.StepsMapper;
 

@UsingSteps(instances = { StepsMapper.class })
public class ImpostosCalculo  extends JUnitStory {
	
	@Override 
	public Configuration configuration() {
		ParameterControls parameterControls = new ParameterControls()
											.useDelimiterNamedParameters(true)
											.useNameDelimiterLeft("<")
											.useNameDelimiterRight(">");
		
		Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");
		
		TableTransformers tableTransformers = new TableTransformers();
		ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(new LocalizedKeywords(),
                new LoadFromClasspath(this.getClass()), tableTransformers);
		
		StoryReporterBuilder storyReporterBuilder =  new StoryReporterBuilder()
                .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
                .withDefaultFormats()
                .withFailureTrace(true)
                .withFailureTraceCompression(true)
                .withViewResources(viewResources)
                .withFormats(Format.CONSOLE, Format.TXT, Format.HTML, Format.XML);
		
		return new MostUsefulConfiguration()
				.useParameterControls(parameterControls)
				.useStoryReporterBuilder(storyReporterBuilder);
	}
	
	@Override 
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(),
                                    new StepsMapper());
	}
	
}