package org.aracrown.commons.mail;

import java.io.File;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.aracrown.commons.util.ProxiedParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;

@ApplicationScoped
public class TemplateConfigProducer {
	private static final String DEFAULT_TEMPLATE_DIR = "/tmp/templates";
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateConfigProducer.class);

	@Produces
	@ApplicationScoped
	public ProxiedParam<Configuration> produceConfiguration() {
		Configuration cfg = createFreemarkerConfiguration();

		ProxiedParam<Configuration> configurationParam = new ProxiedParam<>(cfg);
		return configurationParam;
	}

	private Configuration createFreemarkerConfiguration() {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_21);
		TemplateLoader[] loaders = getTemplateLoaders();
		MultiTemplateLoader mtl = new MultiTemplateLoader(loaders);

		cfg.setTemplateLoader(mtl);
		return cfg;
	}

	private TemplateLoader[] getTemplateLoaders() {
		ClassTemplateLoader ctl = new ClassTemplateLoader(getClass(), "/templates");
		try {
			FileTemplateLoader ftl1 = new FileTemplateLoader(new File(DEFAULT_TEMPLATE_DIR));
			return new TemplateLoader[] { ftl1, ctl };
		} catch (IOException e) {
			LOGGER.warn("Directory does not exist: {}", DEFAULT_TEMPLATE_DIR, e);
			return new TemplateLoader[] { ctl };
		}
	}
}
