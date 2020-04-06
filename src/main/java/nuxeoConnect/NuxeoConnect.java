package nuxeoConnect;

import org.nuxeo.client.NuxeoClient;
import org.nuxeo.client.objects.Document;
import org.nuxeo.client.objects.Repository;

public class NuxeoConnect {
	public static void main(String args[]) {

		// Nuxeo Java Client is created
		NuxeoClient client = new NuxeoClient.Builder().url("http://localhost:8080/nuxeo")
				.authentication("Administrator", "Administrator").schemas("*") // fetch all document schemas
				.connect();

		Repository repository = client.repository();

		Document file = Document.createWithName("One", "Band");
		file.setPropertyValue("band:abbr", "ELF");
		file.setPropertyValue("band:band_name", "Extremely Low Frequnecy");
		file.setPropertyValue("band:band_no", 1);
		file.setPropertyValue("band:h_freq", 30);
		file.setPropertyValue("band:l_freq", 3);
		file = repository.createDocumentByPath("/default-domain/workspaces/Bikings/Liferay", file);
	

	}

}
