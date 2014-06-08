package org.aracrown.commons.ui;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

/**
 * Default interface of {@link IDataProvider}.
 * 
 * @author vicento.ramos
 *
 * @param <T>
 */
public interface DataProvider<T> extends IDataProvider<T> {
	@Override
	public default void detach() {
		// Default detach method left empty.
	}

	@Override
	public default IModel<T> model(T object) {
		return new CompoundPropertyModel<>(object);
	}
}
