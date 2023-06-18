import java.io.*;

/**
 * FileLoader: FileWriter class for Q1
 * 
 * @author JaeHyun Yoon
 * @since 06-18-2023
 */

class FileLoader {
	private File file;
	private FileOutputStream outStream;
	private PrintWriter writer;
	private int line = 0;

	public FileLoader(String name) throws IOException {
		file = new File(name);
		outStream = new FileOutputStream(file);
		writer = new PrintWriter(outStream);
	}

	public PrintWriter getWriter() {
		line++;
		return writer;
	}

	public void close() throws IOException {
		writer.close();
		outStream.close();
	}

	public int getLine() {
		return line;
	}
}
