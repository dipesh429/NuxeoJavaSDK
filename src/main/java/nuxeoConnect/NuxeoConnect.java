package nuxeoConnect;

import java.io.File;
import java.util.Map;

import org.nuxeo.client.NuxeoClient;
import org.nuxeo.client.objects.Document;
import org.nuxeo.client.objects.Repository;
import org.nuxeo.client.objects.blob.Blob;
import org.nuxeo.client.objects.blob.FileBlob;
import org.nuxeo.client.objects.upload.BatchUpload;
import org.nuxeo.client.objects.upload.BatchUploadManager;

public class NuxeoConnect {
	public static void main(String args[]) {

		// Nuxeo Java Client is created
		NuxeoClient client = new NuxeoClient.Builder().url("http://tourismministry.phoenixsolutions.com.np:8888/nuxeo")
				.authentication("Administrator", "Administrator").schemas("*") // fetch all document schemas
				.connect();

			

		Repository repository = client.repository();

		//Add

		Document file = Document.createWithName("One", "Band");
		file.setPropertyValue("band:abbr", "ELF");
		file.setPropertyValue("band:band_name", "Extremely Low Frequnecy");
		file.setPropertyValue("band:band_no", 1);
		file.setPropertyValue("band:h_freq", 30);
		file.setPropertyValue("band:l_freq", 3);
		file = repository.createDocumentByPath("/default-domain/workspaces/Bikings/Liferay", file);
		

		//fetching

		// Document myfile = repository.fetchDocumentByPath("/default-domain/workspaces/Bikings/Liferay/One");
		// String title = myfile.getPropertyValue("band:band_name"); // equals to folder
		// System.out.println(title);





		// myfile.setPropertyValue("dc:custom", "oiiiii");
		// repository.updateDocument(myfile);

		// creating document folder

		// Document folder = Document.createWithName("Root Folder", "Folder");
		// folder = repository.createDocumentByPath("/", folder);


//creating note
		// Document note = Document.createWithName("note001", "Note");
		// note = repository.createDocumentByPath("/default-domain/workspaces/Phoenix/DipeshCollection", note);

		// Document file = Document.createWithName("vechicle", "Vehicle");
		// file.setPropertyValue("veh:organization", "orgB");
		// file.setPropertyValue("veh:sth", "orgA");
		// file.setPropertyValue("phoenixphoto:Categoryy", "CLASS D");
		// file.setPropertyValue("phoenixphoto:Country", "Nepal");
		// file = repository.createDocumentByPath("/", file);
		// System.out.println(file.getPropertyValue("veh:organization"));
		// System.out.println(file.getPropertyValue("veh:sth"));
	
		// Document domain = client.repository().fetchDocumentByPath("/default-domain");

		// Let's first retrieve batch upload manager to handle our batch:
		// BatchUploadManager batchUploadManager = client.batchUploadManager();

		// // // getting local file
		// ClassLoader classLoader = new NuxeoConnect().getClass().getClassLoader();
		// File file = new File(classLoader.getResource("dipesh.jpg").getFile());

		// // // create a new batch
		// BatchUpload batchUpload = batchUploadManager.createBatch();
		// Blob fileBlob = new FileBlob(file);
		// batchUpload = batchUpload.upload("0", fileBlob);

		// // // attach the blob
		
		// Document doc = client.repository().fetchDocumentByPath("/default-domain/workspaces/Phoenix/DipeshCollection/dipeshFile");
		// doc.setPropertyValue("file:content", batchUpload.getBatchBlob());
		// doc = doc.updateDocument();
		// // get
		// Map pic = doc.getPropertyValue("file:content");
		// System.out.print(pic);
	}

}
