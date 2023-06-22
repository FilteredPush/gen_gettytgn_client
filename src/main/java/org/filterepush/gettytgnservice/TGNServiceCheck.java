package org.filterepush.gettytgnservice;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import edu.getty.tgn.objects.Vocabulary;
import edu.getty.tgn.objects.Vocabulary.Subject;
import edu.getty.tgn.objects.Vocabulary.Subject.Term;
import edu.getty.tgn.service.ArrayOfListResults;
import edu.getty.tgn.service.ListResults;
import edu.getty.tgn.service.TGNWebServices;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

/**
 * Check/demonstrate use of selected service endpoints.
 *
 */
public class TGNServiceCheck {
    public static void main( String[] args ) {
    	
    	TGNWebServices tgn = new TGNWebServices();
    	try {
			ArrayOfListResults retval = tgn.getTGNWebServicesSoap().tgnGetNations("", "");
			List<ListResults> retList =  retval.getListResults();
			Iterator<ListResults> i = retList.iterator();
			while (i.hasNext()) { 
				ListResults row = i.next();
				System.out.println(row.getListValue());
				System.out.println(row.getListId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//String sovereignNationPlaceTypeID = "81011";
    	//TGNGetTermMatchResult retval = tgn.getTGNWebServicesSoap().tgnGetTermMatch("Uganda", sovereignNationPlaceTypeID,"");
    	//System.out.println(retval.getContent());
    	
    	String request = "http://vocabsservices.getty.edu//TGNService.asmx/TGNGetTermMatch?name=Uganda&placetypeid=81010&nationid=";
    	try {
    		URL url = new URL(request);
    		HttpURLConnection getty = (HttpURLConnection) url.openConnection();
    		InputStream is = getty.getInputStream();
    		JAXBContext jc = JAXBContext.newInstance(Vocabulary.class);
			Unmarshaller unmarshaler = jc.createUnmarshaller();
			Vocabulary response = (Vocabulary) unmarshaler.unmarshal(is);
			System.out.println(response.getCount());
			List<Subject> subjects = response.getSubject();
			Iterator<Subject> i = subjects.iterator();
			while (i.hasNext()) {
				Subject subject = i.next();
				System.out.println(subject.getPreferredTerm().getValue());
				System.out.println(subject.getSubjectID());
				System.out.println(subject.getPreferredParent());
				List<Term> terms = subject.getTerm();
				Iterator<Term> it = terms.iterator();
				while (it.hasNext()) { 
					Term term = it.next();
					System.out.println(term.getValue());
				}
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
