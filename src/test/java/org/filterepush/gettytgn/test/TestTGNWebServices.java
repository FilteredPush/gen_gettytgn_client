package org.filterepush.gettytgn.test;
/**
 * TestTGNWebServices.java
 */

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.getty.tgn.service.ListSubject;
import edu.getty.tgn.service.TGNWebServices;
import edu.getty.tgn.service.Vocabulary;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

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
    	
    	String sovereignNationPlaceTypeID = "81011";
    	
    	
    	
    	Vocabulary retval = tgn.getTGNWebServicesSoap().tgnGetTermMatch("Uganda", sovereignNationPlaceTypeID,"");
    	
    	System.out.println(retval.toString());
    	System.out.println(retval.getCount());
    	List<ListSubject> contentList = (List<ListSubject>)retval.getListSubject();
    	System.out.println(contentList.toString());
    	System.out.println(contentList.size());
    	//System.out.println(contentList.get(0));
    	Iterator<ListSubject> i = contentList.iterator();
    	while (i.hasNext()) { 
    		ListSubject item = i.next();
    		System.out.println(item);
    		System.out.println(item.getPreferredTerm());
    	}
    	
	}

}
