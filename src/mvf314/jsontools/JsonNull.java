package mvf314.jsontools;

public class JsonNull extends JsonEntry {

	public JsonNull(int indents, String key) {
		super(indents, key);
	}

	@Override
	public String get() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append(Tools.kvPair(key, "null"));
		sb.append(",\n");
		return sb.toString();
	}

	@Override
	public String getValue() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append("null");
		sb.append(",\n");
		return sb.toString();
	}
}
