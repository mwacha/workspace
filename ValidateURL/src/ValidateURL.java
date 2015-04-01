import java.net.MalformedURLException;
import java.net.URL;


public class ValidateURL {
//	
//	Saída:
//		protocolo: http
//		host: www
//		domínio: google.com
//		path: mail
//		parâmetros: user=fulano
//		
		
			
		    public static void main(String[] args) throws Exception {

		        try {
		        	URL aURL = new URL("htt://www.google.com/mail/user=fulano");
		        	System.out.println("protocolo = " + aURL.getProtocol());		        
		        	System.out.println("host = " + getHost(aURL.toString()));
		        	System.out.println("domínio = " + getDomain(aURL.getHost()));
		        	System.out.println("path = " + getPath(aURL.getPath()));		        
		        	System.out.println("parâmetro = " + getPameter(aURL.toString()));
		        	
		        } catch(MalformedURLException e) {
		        	throw new MalformedURLException("Invalid URL");
		        }
		    }
		    
		    
		    public static String getHost(String url){
		        if(url == null || url.length() == 0)
		            return "";

		        int doubleslash = url.indexOf("//");
		        if(doubleslash == -1)
		            doubleslash = 0;
		        else
		            doubleslash += 2;

		        int end = url.indexOf('.', doubleslash);
		        end = end >= 0 ? end : url.length();

		        int port = url.indexOf(':', doubleslash);
		        end = (port > 0 && port < end) ? port : end;

		        return url.substring(doubleslash, end);
		    }

		    
		    public static String getDomain(String url) {
		        String host = url;

		        int startIndex = 0;
		        int nextIndex = host.indexOf('.');
		        int lastIndex = host.lastIndexOf('.');
		        while (nextIndex < lastIndex) {
		            startIndex = nextIndex + 1;
		            nextIndex = host.indexOf('.', startIndex);
		        }
		        if (startIndex > 0) {
		            return host.substring(startIndex);
		        } else {
		            return host;
		        }
		    }
		    
		    public static String getPath(String url) {
		        String host = url;

		        int startIndex = 0;
		        int nextIndex = host.indexOf('/');
		        int lastIndex = host.lastIndexOf('/');
		     
		        startIndex = nextIndex + 1;
		        nextIndex = host.indexOf('/', startIndex);
		     
		        if (startIndex > 0) {
		            return host.substring(startIndex, lastIndex);
		        } else {
		            return host;
		        }
		    }
		    
		    public static String getPameter(String url) {
		        String host = url;

		        int startIndex = 0;
		        int nextIndex = host.indexOf('/');
		        int lastIndex = host.lastIndexOf('/');
		        while (nextIndex < lastIndex) {
		            startIndex = nextIndex + 1;
		            nextIndex = host.indexOf('/', startIndex);
		        }
		        if (startIndex > 0) {
		            return host.substring(++nextIndex);
		        } else {
		            return host;
		        }
		    }

}
