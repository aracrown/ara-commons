package org.aracrown.commons.mail;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.aracrown.commons.util.ProxiedParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Named
public class TemplateProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateProcessor.class);

	@Inject
	private ProxiedParam<Configuration> templateConfiguration;

	public TemplateProcessor() {
	}

	TemplateProcessor(ProxiedParam<Configuration> templateConfiguration) {
		this.templateConfiguration = templateConfiguration;
	}

	public String processTemplate(String templateName, Map<String, String> params) throws TemplateProcessorException {
		try {
			Template template = templateConfiguration.getParam().getTemplate(templateName);
			Writer out = new StringWriter();
			template.process(params, out);
			return out.toString();
		} catch (IOException | TemplateException e) {
			LOGGER.error("Error occured while trying to process template {}", templateName, e);
			throw new TemplateProcessorException("Error occured while trying to process template.", e);
		}

	}
}
