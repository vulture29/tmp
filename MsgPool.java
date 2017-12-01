import java.io.*;
import java.util.*;

/**
 * This class is used to store all messages and their filenames
 */
class MsgPool {
	private Map<String, List<Message>> msgMap;
	private Map<String, Integer> matchTimeMap;

	public MsgPool() {
		msgMap = new HashMap<String, List<Message>>();
		matchTimeMap = new HashMap<String, Integer>();
	}

	/**
	 * Add one record
	 * @param String        filename
	 * @param List<Message> msgList  corresponding message list
	 */
	public void add(String filename, List<Message> msgList) {
		msgMap.put(filename, msgList);
	}

	/**
	 * search for one word
	 * @param  String word          the word to search in the pool
	 * @return        the message List that contains the word
	 */
	public List<Message> search(String word) {
		List<Message> retMsgList = new LinkedList<Message>();

		// loop the msgMap to search for messages
		for(String filename : msgMap.keySet()) {
			List<Message> loopMsgList = msgMap.get(filename);
			for(Message msg : loopMsgList) {
				if(msg.contains(word)) {
					// update matchTimeMap
					if(matchTimeMap.containsKey(filename)) {
						matchTimeMap.put(filename, matchTimeMap.get(filename)+1);
					}
					else {
						matchTimeMap.put(filename, 1);
					}

					// update msgMap
					retMsgList.add(msg);
				}
			}
		}

		return retMsgList;
	}

	/**
	 * print the match time to stdout
	 */
	public void printMatchTime() {
		for(String filename : matchTimeMap.keySet()) {
			System.out.println(filename + ": " + matchTimeMap.get(filename));
		}
	}
}
