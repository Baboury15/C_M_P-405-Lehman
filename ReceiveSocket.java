import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveSocket {

	private static InetAddress myAddress = null;

	public static void main(String[] args) {

		try {
			myAddress = InetAddress.getLocalHost();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

		System.out.println("My Address = " + myAddress.getHostAddress());

		DatagramSocket inSocket = null;
		byte[] inBuffer = new byte[1000];
		DatagramPacket inPacket = new DatagramPacket(inBuffer, inBuffer.length);

		try {
			inSocket = new DatagramSocket(64000, myAddress);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

		do {
			for (int i = 0; i < inBuffer.length; i++) {
				inBuffer[i] = ' ';
			}

			try {

				System.out.println("Waiting for input...");
				inSocket.receive(inPacket);
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}

			String message = new String(inPacket.getData());
			System.out.println("Received message = " + message);

		} while (true);
	}
}
