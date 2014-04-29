package org.aracrown.commons.persistence;

import org.junit.Test;

/**
 * Created by turisto on 02/04/2014.
 */
public class FakeEntityDeleteQueryTest extends AbstractDaoTest {
    @Test
    public void testGetDeleteClause() throws Exception {
    	FakeEntityDeleteQuery deleteQuery = new FakeEntityDeleteQuery(em).name("test");
    	deleteQuery.execute();
    }

    @Test
    public void testGetPath() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {

    }
}
