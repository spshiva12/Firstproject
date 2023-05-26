import java.util.Base64;

public class Converty {

	public String base64Encoder(String data) {

		String s = Base64.getEncoder().encodeToString(data.getBytes());
		return s;
	}

	public String base64Decoder(String data) {
		byte[] b = Base64.getDecoder().decode(data);
		String str = new String(b);
		return str;

	}

	public static void main(String[] args) {
		Converty c = new Converty();
		String str1 = c.base64Encoder("shiva123");
		System.out.println("Encoded data:" + str1);
		String str2 = c.base64Decoder(str1);
		System.out.println("Decoded data:" + str2);
	}

}
