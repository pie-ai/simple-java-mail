

package sockslib.utils;

import static sockslib.utils.Util.checkNotNull;

public class LogMessageBuilder {

	public static String build(byte[] bytes, MsgType type) {
		return build(bytes, bytes.length, type);
	}

	public static String build(byte[] bytes, final int size, MsgType type) {
		checkNotNull(bytes, "Argument [bytes] may not be null");
		checkNotNull(type, "Argument [type] may not be null");
		StringBuilder debugMsg = new StringBuilder();
		switch (type) {
			case RECEIVE:
				debugMsg.append("Received: ");
				break;
			case SEND:
				debugMsg.append("Sent: ");
				break;
			default:
				break;

		}

		for (int i = 0; i < size; i++) {
			int x = UnsignedByte.toInt(bytes[i]);
			debugMsg.append(Integer.toHexString(x)).append(" ");
		}
		return debugMsg.toString();
	}

	public enum MsgType {
		SEND, RECEIVE
	}

}