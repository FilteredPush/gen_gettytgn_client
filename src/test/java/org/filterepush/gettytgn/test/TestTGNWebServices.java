package org.filterepush.gettytgn.test;
/**
 * TestTGNWebServices.java
 */

import static org.junit.Assert.fail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.getty.tgn.service.TGNGetTermMatchResponse.TGNGetTermMatchResult;
import edu.getty.tgn.service.TGNWebServices;
import org.junit.Test;

/**
 * @author mole
 *
 */
public class TestTGNWebServices {

	private static final Log logger = LogFactory.getLog(TestTGNWebServices.class);

	/**
	 * Minimal test for generated TGN service code.
	 */
	@Test
	public void testTGNMinimal() {
		
    	TGNWebServices tgn = new TGNWebServices();
    	
    	String sovereignStatePlaceTypeID = "300232420";
    	
    	TGNGetTermMatchResult retval = tgn.getTGNWebServicesSoap().tgnGetTermMatch("Uganda", sovereignStatePlaceTypeID, "");
    	
    	logger.debug(retval.getContent());
		
		fail("Not yet implemented");
	}

}
