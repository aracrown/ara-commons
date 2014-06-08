package org.aracrown.commons.ui;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.aracrown.commons.data.ResourceCollectionResponse;

/**
 * Abstract customized data provider to query REST services.
 * 
 * @author vicento.ramos Ø
 * @param <T>
 *            data entity type
 */
public abstract class DataProvider<T> implements IDataProvider<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** First page is loaded on total count query. */
	private List<T> loaded;

	/** Fetch size on initial request. */
	private long size = -1L;

	@Override
	public void detach() {
	}

	@Override
	public Iterator<T> iterator(long first, long count) {
		if (first == 0) {
			return loaded.iterator();
		}
		return query(first, count).getItems().iterator();
	}

	@Override
	public long size() {
		if (size < 0) {
			ResourceCollectionResponse<T> items = query(0, 10L);
			loaded = items.getItems();

			size = items.getTotal();
		}
		return size;
	}

	/**
	 * Query required page of data.
	 * 
	 * @param first
	 *            page to query
	 * @param pageSize
	 *            page size
	 * @return resource list
	 */
	protected abstract ResourceCollectionResponse<T> query(long first, long pageSize);
}
