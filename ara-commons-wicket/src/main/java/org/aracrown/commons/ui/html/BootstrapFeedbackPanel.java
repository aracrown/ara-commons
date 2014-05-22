package org.aracrown.commons.ui.html;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FeedbackMessagesModel;
import org.apache.wicket.feedback.IFeedback;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.settings.IApplicationSettings;

/**
 * Customized version of feedback panel. Custom css added and <b>removed parent level css</b>.  
 * 
 * @author vicento.ramos
 *
 */
public class BootstrapFeedbackPanel extends Panel implements IFeedback {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Message view. */
	private final BootstrapMessageListView messageListView;

	/**
	 * @see org.apache.wicket.Component#Component(String)
	 * 
	 * @param id
	 *            The non-null id of this component
	 */
	public BootstrapFeedbackPanel(final String id) {
		this(id, null);
	}

	/**
	 * @see org.apache.wicket.Component#Component(String)
	 * 
	 * @param id
	 *            The non-null id of this component
	 * @param filter
	 *            feedback message filter
	 */
	public BootstrapFeedbackPanel(final String id, IFeedbackMessageFilter filter) {
		super(id);
		WebMarkupContainer messagesContainer = new WebMarkupContainer("feedbackul") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(anyMessage());
			}
		};
		add(messagesContainer);
		messageListView = new BootstrapMessageListView("messages");
		messageListView.setVersioned(false);
		messagesContainer.add(messageListView);

		if (filter != null) {
			setFilter(filter);
		}
	}

	protected String getCSSClass(FeedbackMessage message) {
		String cssClass = "alert alert-info";
		switch (message.getLevel()) {
		case FeedbackMessage.ERROR:
			cssClass = "alert alert-danger";
			break;
		case FeedbackMessage.SUCCESS:
			cssClass = "alert alert-success";
			break;
		default:
			break;
		}
		return cssClass;
	}

	/**
	 * Customized version of feedback message view. Removed css from parent level list item.
	 * 
	 * @author vicento.ramos
	 *
	 */
	class BootstrapMessageListView extends ListView<FeedbackMessage> {

		

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * @see org.apache.wicket.Component#Component(String)
		 */
		public BootstrapMessageListView(final String id) {
			super(id);
			setDefaultModel(newFeedbackMessagesModel());
		}

		@Override
		protected IModel<FeedbackMessage> getListItemModel(final IModel<? extends List<FeedbackMessage>> listViewModel, final int index) {
			return new AbstractReadOnlyModel<FeedbackMessage>() {
				private static final long serialVersionUID = 1L;

				/**
				 * WICKET-4258 Feedback messages might be cleared already.
				 * 
				 * @see IApplicationSettings#setFeedbackMessageCleanupFilter(org.apache.wicket.feedback.IFeedbackMessageFilter)
				 */
				@Override
				public FeedbackMessage getObject() {
					if (index >= listViewModel.getObject().size()) {
						return null;
					} else {
						return listViewModel.getObject().get(index);
					}
				}
			};
		}

		@Override
		protected void populateItem(ListItem<FeedbackMessage> listItem) {
			final FeedbackMessage message = listItem.getModelObject();
			message.markRendered();
			final Component label = newMessageDisplayComponent("message", message);
			final AttributeModifier levelModifier = AttributeModifier.append("class", getCSSClass(message));
			label.add(levelModifier);
			listItem.add(label);
		}

	}

	/**
	 * Search messages that this panel will render, and see if there is any message of level ERROR or up. This is a convenience method; same as
	 * calling 'anyMessage(FeedbackMessage.ERROR)'.
	 * 
	 * @return whether there is any message for this panel of level ERROR or up
	 */
	public final boolean anyErrorMessage() {
		return anyMessage(FeedbackMessage.ERROR);
	}

	/**
	 * Search messages that this panel will render, and see if there is any message.
	 * 
	 * @return whether there is any message for this panel
	 */
	public final boolean anyMessage() {
		return anyMessage(FeedbackMessage.UNDEFINED);
	}

	/**
	 * Search messages that this panel will render, and see if there is any message of the given level.
	 * 
	 * @param level
	 *            the level, see FeedbackMessage
	 * @return whether there is any message for this panel of the given level
	 */
	public final boolean anyMessage(int level) {
		List<FeedbackMessage> msgs = getCurrentMessages();

		for (FeedbackMessage msg : msgs) {
			if (msg.isLevel(level)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @return Model for feedback messages on which you can install filters and other properties
	 */
	public final FeedbackMessagesModel getFeedbackMessagesModel() {
		return (FeedbackMessagesModel) messageListView.getDefaultModel();
	}

	/**
	 * @return The current message filter
	 */
	public final IFeedbackMessageFilter getFilter() {
		return getFeedbackMessagesModel().getFilter();
	}

	/**
	 * @return The current sorting comparator
	 */
	public final Comparator<FeedbackMessage> getSortingComparator() {
		return getFeedbackMessagesModel().getSortingComparator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isVersioned() {
		return false;
	}

	/**
	 * Sets a filter to use on the feedback messages model.
	 * 
	 * @param filter
	 *            The message filter to install on the feedback messages model
	 * 
	 * @return FeedbackPanel this.
	 */
	public final BootstrapFeedbackPanel setFilter(IFeedbackMessageFilter filter) {
		getFeedbackMessagesModel().setFilter(filter);
		return this;
	}

	/**
	 * @param maxMessages
	 *            The maximum number of feedback messages that this feedback panel should show at one time
	 * 
	 * @return FeedbackPanel this.
	 */
	public final BootstrapFeedbackPanel setMaxMessages(int maxMessages) {
		messageListView.setViewSize(maxMessages);
		return this;
	}

	/**
	 * Sets the comparator used for sorting the messages.
	 * 
	 * @param sortingComparator
	 *            comparator used for sorting the messages.
	 * 
	 * @return FeedbackPanel this.
	 */
	public final BootstrapFeedbackPanel setSortingComparator(Comparator<FeedbackMessage> sortingComparator) {
		getFeedbackMessagesModel().setSortingComparator(sortingComparator);
		return this;
	}

	/**
	 * Gets the currently collected messages for this panel.
	 * 
	 * @return the currently collected messages for this panel, possibly empty
	 */
	protected final List<FeedbackMessage> getCurrentMessages() {
		final List<FeedbackMessage> messages = messageListView.getModelObject();
		return Collections.unmodifiableList(messages);
	}

	/**
	 * Gets a new instance of FeedbackMessagesModel to use.
	 * 
	 * @return Instance of FeedbackMessagesModel to use
	 */
	protected FeedbackMessagesModel newFeedbackMessagesModel() {
		return new FeedbackMessagesModel(this);
	}

	/**
	 * Generates a component that is used to display the message inside the feedback panel. This component must handle being attached to
	 * <code>span</code> tags.
	 * 
	 * By default a {@link Label} is used.
	 * 
	 * Note that the created component is expected to respect feedback panel's {@link #getEscapeModelStrings()} value
	 * 
	 * @param id
	 *            parent id
	 * @param message
	 *            feedback message
	 * @return component used to display the message
	 */
	protected Component newMessageDisplayComponent(String id, FeedbackMessage message) {
		Serializable serializable = message.getMessage();
		Label label = new Label(id, (serializable == null) ? "" : serializable.toString());
		label.setEscapeModelStrings(BootstrapFeedbackPanel.this.getEscapeModelStrings());
		return label;
	}
}
