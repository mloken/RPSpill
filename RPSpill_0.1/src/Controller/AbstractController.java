package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractController {
	private BufferedReader input;

	public AbstractController() {
		this.input = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String waitForInput() throws IOException {
		return waitForInput(false);
	}

	public String waitForInput(boolean allow_empty) throws IOException {
		String s;
		do {
			s = input.readLine();
			if (s == null) {
				continue;
			}
			s = s.replace("\n", "").replace("\r", "");
			if (s.length() == 0 && !allow_empty) {
				continue;
			}
			break;
		} while (true);
		return s;
	}
}
