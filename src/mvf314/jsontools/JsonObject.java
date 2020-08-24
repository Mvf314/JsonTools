package mvf314.jsontools;

import java.util.ArrayList;

public class JsonObject extends JsonEntry {

	private ArrayList<JsonEntry> entries;

	public JsonObject(int indents, String key) {
		super(indents, key);
		entries = new ArrayList<>();
	}

	public JsonObject add(JsonEntry entry) {
		entry.indents = indents + 1;
		entries.add(entry);
		return this;
	}

	@Override
	public String get() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append(Tools.makeString(key));
		sb.append(": {\n");
		for (JsonEntry entry : entries) {
			entry.indents = indents + 1;
			sb.append(entry.get());
		}
		// Delete last comma
		if (entries.size() > 0) {
			sb.deleteCharAt(sb.length() - 2);
		}
		Tools.indent(sb, indents);
		sb.append("},\n");
		return sb.toString();
	}

	@Override
	public String getValue() {
		StringBuilder sb = new StringBuilder();
		Tools.indent(sb, indents);
		sb.append("{\n");
		for (JsonEntry entry : entries) {
			entry.indents = indents + 1;
			sb.append(entry.get());
		}
		// Delete last comma
		if (entries.size() > 0) {
			sb.deleteCharAt(sb.length() - 2);
		}
		Tools.indent(sb, indents);
		sb.append("},\n");
		return sb.toString();
	}
}
