package mvf314.jsontools;

public class JsonNumber extends JsonEntry {

	private int intValue;
	private float floatValue;
	private double doubleValue;

	private int set;

	public JsonNumber(int indents, String key, int value) {
		super(indents, key);
		this.intValue = value;
		set = 1;
	}

	public JsonNumber(int indents, String key, float value) {
		super(indents, key);
		this.floatValue = value;
		set = 0;
	}

	public JsonNumber(int indents, String key, double value) {
		super(indents, key);
		this.doubleValue = value;
		set = -1;
	}

	@Override
	public String get() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		if (set == 1) {
			sb.append(Tools.kvPair(key, Integer.toString(intValue)));
		} else if (set == 0) {
			sb.append(Tools.kvPair(key, Float.toString(floatValue)));
		} else if (set == -1) {
			sb.append(Tools.kvPair(key, Double.toString(doubleValue)));
		}
		sb.append(",\n");
		return sb.toString();
	}

	@Override
	public String getValue() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		if (set == 1) {
			sb.append(intValue);
		} else if (set == 0) {
			sb.append(floatValue);
		} else if (set == -1) {
			sb.append(doubleValue);
		}
		sb.append(",\n");
		return sb.toString();
	}
}
