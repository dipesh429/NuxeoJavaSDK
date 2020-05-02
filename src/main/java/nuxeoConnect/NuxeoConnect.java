package nuxeoConnect;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.nuxeo.client.NuxeoClient;
import org.nuxeo.client.objects.Document;
import org.nuxeo.client.objects.Repository;
import org.nuxeo.client.objects.blob.Blob;
import org.nuxeo.client.objects.blob.FileBlob;
import org.nuxeo.client.objects.upload.BatchUpload;
import org.nuxeo.client.objects.upload.BatchUploadManager;
import org.nuxeo.client.objects.user.Group;
import org.nuxeo.client.objects.user.User;
import org.nuxeo.client.objects.user.UserManager;

public class NuxeoConnect {
	public static void main(String args[]) {

		// Nuxeo Java Client is created
		// NuxeoClient client = new NuxeoClient.Builder().url("http://localhost:8080/nuxeo")
		NuxeoClient client = new NuxeoClient.Builder().url("http://tourismministry.phoenixsolutions.com.np:8888/nuxeo")
				.authentication("Administrator", "Administrator").schemas("*") // fetch all document schemas
				.connect();
		Repository repository = client.repository();

//Menu
	//create
		// Document file = Document.createWithName("One", "Band");
		Document menu = Document.createWithName("मेनु", "Folder");
		// menu.setPropertyValue("band:abbr", "ELF");
		repository.createDocumentByPath("/", menu);
		Document report = Document.createWithName("प्रतिबेदन्हारू", "Folder");
		repository.createDocumentByPath("/मेनु", report);
		Document event = Document.createWithName("कार्यक्रम", "Folder");
		repository.createDocumentByPath("/मेनु", event);
		Document meeting = Document.createWithName("बैठक", "Folder");
		repository.createDocumentByPath("/मेनु", meeting);
		Document ics = Document.createWithName("केन्द्रिय बेरुजु अवस्था", "Folder");
		repository.createDocumentByPath("/मेनु", ics);


		UserManager userManager = client.userManager();

		createUsers(userManager,"Operator","Operator","phoenix","operator");
		createUsers(userManager,"Secretary","Secretary","phoenix","secretary");
		createUsers(userManager,"DepSecretary","DepSecretary","phoenix","depsecretary");
		createUsers(userManager,"Education","Education","phoenix","education");
		createUsers(userManager,"Health","Health","phoenix","health");
		createUsers(userManager,"Tourism","Tourism","phoenix","tourism");

		String[] memberUsersSecretariat = {"Operator","Secretary","DepSecretary"};
		String[] memberUsersBeruju = {"Education","Health","Tourism"};
		createGroup(userManager,"Secretariat","Secretariat",memberUsersSecretariat);
		createGroup(userManager,"Beruju","Beruju",memberUsersBeruju);
	
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

	public static void createUsers(UserManager userManager,String userName,String firstName,String companyName,String password){
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setCompany(companyName);
		user.setPassword(password);
		user = userManager.createUser(user);
	}

	public static void createGroup(UserManager userManager,String groupName,String groupLabel,String[] memberUsers){
		Group group = new Group();
		group.setGroupName(groupName);
		group.setGroupLabel(groupLabel);
		group.setMemberUsers(Arrays.asList(memberUsers));
		group.setParentGroups(Arrays.asList("members"));
		userManager.createGroup(group);
	}

}
