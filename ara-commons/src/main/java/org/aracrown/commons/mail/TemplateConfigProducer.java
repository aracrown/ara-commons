package org.aracrown.commons.mail;

import java.io.File;
import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.aracrown.commons.util.ProxiedParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;

@ApplicationScoped
public class TemplateConfigProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateConfigProducer.class);

	@Inject
	@TemplateDirectory
	private Instance<ProxiedParam<String>> templateDirectory;

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
		
		String templateDir = resolveTemplateDir();
		try {
			if (!Strings.isNullOrEmpty(templateDir)) {
				FileTemplateLoader ftl1 = new FileTemplateLoader(new File(templateDir));
				return new TemplateLoader[] { ftl1, ctl };
			}
		} catch (IOException e) {
			LOGGER.warn("Directory does not exist: {}", templateDir, e);
		}
		return new TemplateLoader[] { ctl };
	}

	private String resolveTemplateDir() {
		if (templateDirectory.isUnsatisfied()) {
			LOGGER.warn("Configuration issue for @TemplateDirectory: Parameter was not created.");
			return null;
		}
		return (templateDirectory.get() != null) ? templateDirectory.get().getParam() : null;
	}
}
