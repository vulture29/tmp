// Write a program that reads N messages from M input files.
// These input messages can contain any characters but you can assume each message can be delimited by the newline (\n) character.
// You can also assume the messages will all fit in memory.

// Once reading of the input is complete,
// create a command line interface for the user which allows them to search for different words existing in the messages.
// When a word is found in a message, display the matching message. Display any matching words in uppercase.
// Allow the user to enter -1 to exit the program.

// When the program terminates,
// display a summary containing the number of searches performed along with the number of words matched across ALL input files.
// You can also include other summary information if you would like.

// Please complete this task by Saturday 12/2/2017 at 12:30 noon EST and send a .tar file with the following contents:

// 1) The source code.
// 2) A readme with instructions on how to build and run the application.
// 3) A test folder with at least 1 sample input file showing your application works.

/**
 * The entry of the application
 */
class Main {

	public static void main(String[] args) {
		// Read msg from input files
		MsgPool msgPool = ReaderHelper.read();

		// Interactive interface for user
		Cmd cmd = new Cmd(msgPool);
		cmd.start();

		// Print summary
		cmd.summary();

		return;
	}
}
