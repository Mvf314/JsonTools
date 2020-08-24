package mvf314.jsontools;

public class Tools {
	public static String makeString(String string) {
		return "\"" + string + "\"";
	}

	public static String kvPair(String key, String value) {
		return makeString(key) + ": " + value;
	}

	public static String kvPairString(String key, String value) {
		return kvPair(key, makeString(value));
	}

	public static void indent(StringBuilder sb, int indents) {
		for (int i = 0; i < indents; i++) {
			sb.append("  ");
		}
	}
}
