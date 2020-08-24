package mvf314.jsontools;

public class JsonBoolean extends JsonEntry {
	private final boolean bool;

	public JsonBoolean(int indents, String key, boolean bool) {
		super(indents, key);
		this.bool = bool;
	}

	@Override
	public String get() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		if (bool) {
			sb.append(Tools.kvPair(key, "true"));
		} else {
			sb.append(Tools.kvPair(key, "false"));
		}
		sb.append(",\n");
		return sb.toString();
	}

	@Override
	public String getValue() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		if (bool) {
			sb.append("true");
		} else {
			sb.append("false");
		}
		sb.append(",\n");
		return sb.toString();
	}
}
