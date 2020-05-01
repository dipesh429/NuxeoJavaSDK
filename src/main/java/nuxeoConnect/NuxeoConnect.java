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
		NuxeoClient client = new NuxeoClient.Builder().url("http://localhost:8080/nuxeo")
				.authentication("Administrator", "Administrator").schemas("*") // fetch all document schemas
				.connect();
		Repository repository = client.repository();

//Menu
	//create
		// Document file = Document.createWithName("One", "Band");
		Document menu = Document.createWithName("मेनु", "Folder");
		// menu.setPropertyValue("band:abbr", "ELF");
		repository.createDocumentByPath("/", menu);

	

	

//fetching

		// Document myfile = repository.fetchDocumentByPath("/default-domain/workspaces/Bikings/Liferay/One");
		// String title = myfile.getPropertyValue("band:band_name"); // equals to folder
		// System.out.println(title);


// file upload

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
