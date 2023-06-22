package org.filterepush.gettytgn.test;
/**
 * TestTGNWebServices.java
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.getty.tgn.objects.Vocabulary;
import edu.getty.tgn.objects.Vocabulary.Subject;
import edu.getty.tgn.objects.Vocabulary.Subject.Term;
import edu.getty.tgn.service.TGNWebServices;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

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
    	
    	
    	
    	// TGNGetTermMatchResult retval = tgn.getTGNWebServicesSoap().tgnGetTermMatch("Uganda", sovereignNationPlaceTypeID,"");
    	
    	//System.out.println(retval.toString());
    	// System.out.println(retval.getContent());
    	//System.out.println(retval.getCount());
//    	List<ListSubject> contentList = (List<ListSubject>)retval.getListSubject();
//    	System.out.println(contentList.toString());
//    	System.out.println(contentList.size());
//    	//System.out.println(contentList.get(0));
//    	Iterator<ListSubject> i = contentList.iterator();
//    	while (i.hasNext()) { 
//    		ListSubject item = i.next();
//    		System.out.println(item);
//    		System.out.println(item.getPreferredTerm());
//    	}
    	
	}
	
	@Test 
	public void testVocabularyObject() { 
		
		String country = "Uganda";
    	String sovereignNationPlaceTypeID = "81011";
		String baseURI = "http://vocabsservices.getty.edu//TGNService.asmx/TGNGetTermMatch?";
		
		StringBuilder request = new StringBuilder();
		request.append(baseURI);
		request.append("name=").append(country);
		request.append("&placetypeid=").append(sovereignNationPlaceTypeID);
		request.append("&nationid=").append("");
    	try {
    		URL url = new URL(request.toString());
    		HttpURLConnection getty = (HttpURLConnection) url.openConnection();
    		InputStream is = getty.getInputStream();
    		JAXBContext jc = JAXBContext.newInstance(Vocabulary.class);
			Unmarshaller unmarshaler = jc.createUnmarshaller();
			Vocabulary response = (Vocabulary) unmarshaler.unmarshal(is);
			System.out.println(response.getCount());
			assertEquals(BigInteger.ONE,response.getCount());
			List<Subject> subjects = response.getSubject();
			Iterator<Subject> i = subjects.iterator();
			while (i.hasNext()) {
				Subject subject = i.next();
				System.out.println(subject.getPreferredTerm().getValue());
				assertEquals("Uganda (nation)", subject.getPreferredTerm().getValue());
				System.out.println(subject.getSubjectID());
				System.out.println(subject.getPreferredParent());
				List<Term> terms = subject.getTerm();
				Iterator<Term> it = terms.iterator();
				while (it.hasNext()) { 
					Term term = it.next();
					System.out.println(term.getValue());
				}
			}
			country = "República+de+Uganda";	
			request = new StringBuilder();
			request.append(baseURI);
			request.append("name=").append(country);
			request.append("&placetypeid=").append(sovereignNationPlaceTypeID);
			request.append("&nationid=").append("");
			
    		url = new URL(request.toString());
    		getty = (HttpURLConnection) url.openConnection();
    		is = getty.getInputStream();
			response = (Vocabulary) unmarshaler.unmarshal(is);
			System.out.println(response.getCount());
			assertEquals(BigInteger.ONE,response.getCount());
			subjects = response.getSubject();
			i = subjects.iterator();
			while (i.hasNext()) {
				Subject subject = i.next();
				System.out.println(subject.getPreferredTerm().getValue());
				assertEquals("Uganda (nation)", subject.getPreferredTerm().getValue());
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
