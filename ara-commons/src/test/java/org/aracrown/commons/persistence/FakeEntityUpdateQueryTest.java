package org.aracrown.commons.persistence;

import org.junit.Test;

/**
 * Created by turisto on 02/04/2014.
 */
public class FakeEntityUpdateQueryTest extends AbstractDaoTest {
    @Test
    public void testUpdateClause() throws Exception {
    	FakeEntityUpdateQuery updateQuery = new FakeEntityUpdateQuery(em).name("test", "test2");
    	updateQuery.execute();
    }

    @Test
    public void testGetPath() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {

    }
}
