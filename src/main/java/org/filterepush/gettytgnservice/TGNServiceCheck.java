package org.filterepush.gettytgnservice;

import java.util.Iterator;
import java.util.List;

import edu.getty.tgn.service.ArrayOfListResults;
import edu.getty.tgn.service.ListResults;
import edu.getty.tgn.service.TGNWebServices;

/**
 * Check one service endpoint.
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
    }
}
