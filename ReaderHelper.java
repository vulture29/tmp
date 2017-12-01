import java.io.*;
import java.util.*;

class ReaderHelper {

  	// Input: Folder name
	// Output: Arrary of File inside the folder
	public static File[] getFilesFromFolder(String folderName) {
		File folder = new File(folderName);
		return folder.listFiles();
	}

  	// Input: File to be read
  	// Output: List of Message inside the file
	public static List<Message> readFromFile(File file) {
		List<Message> msgList = new LinkedList<Message>();

		try {
			// read file line by line
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Message msg = new Message(line);
				msgList.add(msg);
			}
			fileReader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return msgList;
	}

	// Input: void
	// Output: MsgPool from files
	public static MsgPool readFromFile() {
		// get folder name
		Scanner scanner = new Scanner(System.in);

		// get files inside folder
		File[] listOfFiles = ReaderHelper.getFilesFromFolder("input");
		if(listOfFiles == null) {
			System.out.println("No such folder name!");
			System.exit(0);
		}

        // extract and store messages from files
        MsgPool msgPool = new MsgPool();
		for (File file : listOfFiles) {
			String fileName = file.getName();
			List<Message> msgList = ReaderHelper.readFromFile(file);

			msgPool.add(fileName, msgList);
		}
		return msgPool;
	}
}
