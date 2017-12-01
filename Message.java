import java.io.*;
import java.util.*;

/**
 * One meesage that has some words
 */
class Message {
	private String str;
	private String[] words;

	/**
	* construct Message with empty string
	* @return new Message
	*/
	public Message() {
		str = "";
	}

	/**
   * construct Message with given string
   * @return new Message
   */
	public Message(String str) {
		this.str = str;
		words = str.split(" ");
	}

	/**
	 * judge whether one message contains a string
	 * @param  String s             word as string
	 * @return        boolean value, whether the message has the word
	 */
	public boolean contains(String s) {
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * get the string of the message
	 * @return string of the message
	 */
	public String toString() {
		return str;
	}
}
