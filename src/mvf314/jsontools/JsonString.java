package mvf314.jsontools;

public class JsonString extends JsonEntry {

	private final String value;

	public JsonString(int indents, String key, String value) {
		super(indents, key);
		this.value = value;
	}

	@Override
	public String get() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append(Tools.kvPairString(key, value));
		sb.append(",\n");
		return sb.toString();
	}

	@Override
	public String getValue() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append(Tools.makeString(value));
		sb.append(",\n");
		return sb.toString();
	}
}
