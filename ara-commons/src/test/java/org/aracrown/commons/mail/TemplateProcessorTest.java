package org.aracrown.commons.mail;

import java.nio.file.Paths;

import javax.enterprise.inject.Instance;

import org.aracrown.commons.util.ProxiedParam;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TemplateProcessorTest {
	@Test
	public void testDefault() throws TemplateProcessorException {
		Assert.assertNotNull(new TemplateProcessor());
		
		TemplateConfigProducer producer = new TemplateConfigProducer();

		TemplateProcessor p = new TemplateProcessor(producer.produceConfiguration());
		Assert.assertEquals("template value goes here.", p.processTemplate("test.ftl", null));

	}

	@SuppressWarnings({ "unchecked" })
	@Test
	public void testByDir() throws TemplateProcessorException {
		Instance<ProxiedParam<String>> templateDirectory = Mockito.mock(Instance.class);
		ProxiedParam<String> pp = new ProxiedParam<>();
		
		pp.setParam(Paths.get("src/test/resources/templates/").toAbsolutePath().toString());
		
		Mockito.when(templateDirectory.isUnsatisfied()).thenReturn(Boolean.FALSE);
		Mockito.when(templateDirectory.get()).thenReturn(pp);

		TemplateConfigProducer producer = new TemplateConfigProducer(templateDirectory);

		TemplateProcessor p = new TemplateProcessor(producer.produceConfiguration());
		Assert.assertEquals("template val.", p.processTemplate("test2.ftl", null));

	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void testByDirDoesNotExist() throws TemplateProcessorException {
		Instance<ProxiedParam<String>> templateDirectory = Mockito.mock(Instance.class);

		Mockito.when(templateDirectory.isUnsatisfied()).thenReturn(Boolean.FALSE);
		Mockito.when(templateDirectory.get()).thenReturn(new ProxiedParam<String>(Paths.get("src/test/resources/templates2/").toAbsolutePath().toString()));

		TemplateConfigProducer producer = new TemplateConfigProducer(templateDirectory);

		TemplateProcessor p = new TemplateProcessor(producer.produceConfiguration());
		Assert.assertEquals("template val.", p.processTemplate("test2.ftl", null));

	}
	
	@Test(expected=TemplateProcessorException.class)
	public void testTemplateProcessorException() throws TemplateProcessorException {
		TemplateConfigProducer producer = new TemplateConfigProducer();

		TemplateProcessor p = new TemplateProcessor(producer.produceConfiguration());
		Assert.assertEquals("template value goes here.", p.processTemplate("test3.ftl", null));

	}
}
