import java.util.*;
import java.io.*;

class Cmd {
	private MsgPool msgPool;
	private int numSearch;

	public Cmd() {
		this.msgPool = new MsgPool();
		numSearch = 0;
	}

	public Cmd(MsgPool msgPool) {
		this.msgPool = msgPool;
		numSearch = 0;
	}

	// Input: original message and keyword to upper case
	// Output: converted string
	public String keyWordUpperCase(Message msg, String keyword) {
		String[] words = msg.toString().split(" ");
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(keyword)) {
				words[i] = keyword.toUpperCase();
			}
		}
		return String.join(" ", words);
	}

	// start interactive command line
	public void start() {
		while(true) {
			System.out.println("Search words:");
			Scanner scanner = new Scanner(System.in);
			
			String line = scanner.nextLine();

			// break the loop if input is "-1"
			if(line.equals("-1"))	break;

			// split words
			String[] words = line.split(" ");

			// print result for each word
			System.out.println("Result:");
			for(String word : words) {
				List<Message> msgList = msgPool.search(word);
				numSearch++;

				if(msgList.isEmpty()) {
					System.out.println("No matching!");
					continue;
				}

				// print each msg and switch the key as upper case
				for(Message msg : msgList) {
					System.out.println(keyWordUpperCase(msg, word));
				}
			}
		}
	}

	// print summary
	public void summary() {
		System.out.println("Number of searches performed: " + numSearch);
		msgPool.printMatchTime();
	}
}