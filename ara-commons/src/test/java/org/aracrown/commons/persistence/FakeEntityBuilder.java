package org.aracrown.commons.persistence;


public class FakeEntityBuilder extends AbstractBuilder<FakeEntity> {

	public FakeEntityBuilder() {
		super(new FakeEntity());
	}

	public FakeEntityBuilder name(String name) {
		getEntity().setName(name);
		return this;
	}

}
