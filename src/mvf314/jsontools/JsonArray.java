package mvf314.jsontools;

import java.util.ArrayList;

public class JsonArray extends JsonEntry {

	private ArrayList<JsonEntry> entries;

	public JsonArray(int indents, String key) {
		super(indents, key);
		entries = new ArrayList<>();
	}

	public JsonArray add(JsonEntry entry) {
		entry.indents = indents + 1;
		entries.add(entry);
		return this;
	}

	@Override
	public String get() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append(Tools.makeString(key));
		sb.append(": [\n");
		for (JsonEntry entry : entries) {
			entry.indents = indents + 1;
			sb.append(entry.getValue());
		}
		// Delete last comma
		if (entries.size() > 0) {
			sb.deleteCharAt(sb.length() - 2);
		}
		Tools.indent(sb, indents);
		sb.append("],\n");
		return sb.toString();
	}

	@Override
	public String getValue() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append("[\n");
		for (JsonEntry entry : entries) {
			sb.append(entry.getValue());
		}
		// Delete last comma
		if (entries.size() > 0) {
			sb.deleteCharAt(sb.length() - 2);
		}
		Tools.indent(sb, indents);
		sb.append("],\n");
		return sb.toString();
	}
}
