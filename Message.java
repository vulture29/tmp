import java.io.*;
import java.util.*;

class Message {
	private String str;
	private String[] words;

	public Message() {
		str = "";
	}

	public Message(String str) {
		this.str = str;
		words = str.split(" ");
	}

	// Input: word as string
	// Output: boolean value, whether the message has the word
	public boolean contains(String s) {
		for(int i = 0; i < words.length; i++) {
			if(words[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	// Output: string of the message
	public String toString() {
		return str;
	}
}
