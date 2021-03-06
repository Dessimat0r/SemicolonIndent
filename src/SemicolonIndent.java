import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SemicolonIndent {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("No argument given. Usage: semicolonindent.jar <file>");
			return;
		}
		try (InputStream is = new FileInputStream(args[0])) {
			StringBuilder sb = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
				String line = null;
				while ((line = br.readLine()) != null) {
					int i; for (i = 0; i < line.length(); i++) {
						char c = line.charAt(i);
						if (c != '\t') break;
					}
					line = line.substring(i, line.length());
					for (int j = 0; j < i; j++) sb.append(";;;;");
					sb.append(line).append('\n');
				}
			}
			String st = sb.toString();
			System.out.println(st);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
