package org.aracrown.commons.ui.security.panel;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;
import org.aracrown.commons.security.AuthenticationException;
import org.aracrown.commons.security.SecurityService;
import org.aracrown.commons.security.UsernamePasswordToken;
import org.aracrown.commons.ui.html.BootstrapFeedbackPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple login panel.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class SignInPanel extends Panel {

	/** The feedback string constant. */
	private static final String FEEDBACK = "feedback";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SignInPanel.class);

	/** Injected security service instance. */
	@Inject
	private SecurityService securityService;

	/**
	 * Default constructor.
	 * 
	 * @param id
	 *            The non-null id of this component
	 */
	public SignInPanel(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		// Add Signin form
		add(new SignInForm("signIn"));
	}

	/**
	 * Simple sign-in form with username and password. No remember me function used here.
	 * 
	 * @author vicento.ramos
	 * 
	 * @since 1.0.0
	 * 
	 */
	class SignInForm extends StatelessForm<Void> {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/** The username field. */
		private static final String USERNAME = "username";

		/** The password field. */
		private static final String PASSWORD = "password";

		/** The properties, containing username and password fields. */
		private final ValueMap properties = new ValueMap();

		/**
		 * Default constructor.
		 * 
		 * @param id
		 *            The non-null id of this component
		 */
		public SignInForm(String id) {
			super(id);
			// Create feedback panel and add to page
			BootstrapFeedbackPanel feedback = new BootstrapFeedbackPanel(FEEDBACK);
			add(feedback);
			feedback.setVisible(false);

			add(new RequiredTextField<String>(USERNAME, new PropertyModel<String>(properties, USERNAME), String.class));
			add(new PasswordTextField(PASSWORD, new PropertyModel<String>(properties, PASSWORD)));
		}

		@Override
		protected void onSubmit() {
			try {
				if (!authenticate(getUsername(), getPassword())) {
					// In case false was returned instead of exception
					throw new AuthenticationException("LOGIN_ERROR", "Could not login");
				}
				getSession().setLocale(securityService.getLocale());
				continueToOriginalDestination();
				setResponsePage(getApplication().getHomePage());
			} catch (AuthenticationException e) {
				LOGGER.warn("Authentication error", e);
				error(getLocalizer().getString(e.getMessageKey(), SignInPanel.this, e.getMessage()));
				Component feedback = get(FEEDBACK);
				feedback.setVisible(true);
			}
		}

		private String getUsername() {
			return properties.getString(USERNAME);
		}

		private String getPassword() {
			return properties.getString(PASSWORD);
		}
	}

	protected boolean authenticate(String username, String password) {
		try {
			return securityService.authenticate(new UsernamePasswordToken(username, password));
		} catch (Exception e) {
			LOGGER.warn("Login error", e);
			throw new AuthenticationException("LOGIN_ERROR", "Could not login");
		}
	}
}
