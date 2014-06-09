package org.aracrown.commons.ui.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class RefreshOnClickBehaviorTest {
	@SuppressWarnings("unchecked")
	@Test
	public void testDefault() throws Exception {
		Component component = mock(Component.class);
		IEvent<RefreshClick> event = mock(IEvent.class); 
		AjaxRequestTarget target = mock(AjaxRequestTarget.class);
		Mockito.when(event.getPayload()).thenReturn(new RefreshClick(target));
		
		RefreshOnClickBehavior beahvior = new RefreshOnClickBehavior();
		
		
		beahvior.onEvent(component, event);
		Mockito.verify(event, Mockito.atLeastOnce()).getPayload();
		Mockito.verify(target, Mockito.atLeastOnce()).add(component);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testNoPayload() throws Exception {
		Component component = mock(Component.class);
		IEvent<RefreshClick> event = mock(IEvent.class); 
		AjaxRequestTarget target = mock(AjaxRequestTarget.class);
		Mockito.when(event.getPayload()).thenReturn(null);
		
		RefreshOnClickBehavior beahvior = new RefreshOnClickBehavior();
		
		
		beahvior.onEvent(component, event);
		Mockito.verify(event, Mockito.atLeastOnce()).getPayload();
		Mockito.verify(target, Mockito.times(0)).add(component);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testNoRefreshClick() throws Exception {
		Component component = mock(Component.class);
		IEvent<Object> event = mock(IEvent.class); 
		AjaxRequestTarget target = mock(AjaxRequestTarget.class);
		Mockito.when(event.getPayload()).thenReturn(new Object());
		
		RefreshOnClickBehavior beahvior = new RefreshOnClickBehavior();
		
		
		beahvior.onEvent(component, event);
		Mockito.verify(event, Mockito.atLeastOnce()).getPayload();
		Mockito.verify(target, Mockito.times(0)).add(component);
	}
}
