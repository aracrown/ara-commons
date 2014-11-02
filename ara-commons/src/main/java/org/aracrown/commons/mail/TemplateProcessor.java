package org.aracrown.commons.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.aracrown.commons.util.ProxiedParam;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Named
public class TemplateProcessor {
	@Inject
	private ProxiedParam<Configuration> templateConfiguration;
	
	public String processTemplate(String templateName, Map<String, String> params) throws IOException, TemplateException {
		Template template = templateConfiguration.getParam().getTemplate(templateName);

		Writer out = new StringWriter();
		template.process(params, out);
		return out.toString();
	}
}
