package mvf314.jsontools;

import java.util.ArrayList;

public class JsonBuilder {

	private int indents;

	public ArrayList<JsonEntry> entries;


	public JsonBuilder() {
		entries = new ArrayList<>();
		indents = 1;
	}

	public JsonBuilder add(String key, String value) {
		entries.add(new JsonString(indents, key, value));
		return this;
	}

	public JsonBuilder add(String key, boolean bool) {
		entries.add(new JsonBoolean(indents, key, bool));
		return this;
	}

	public JsonBuilder add(String key, int number) {
		entries.add(new JsonNumber(indents, key, number));
		return this;
	}
	public JsonBuilder add(String key, float number) {
		entries.add(new JsonNumber(indents, key, number));
		return this;
	}
	public JsonBuilder add(String key, double number) {
		entries.add(new JsonNumber(indents, key, number));
		return this;
	}

	public JsonBuilder addNull(String key) {
		entries.add(new JsonNull(indents, key));
		return this;
	}


	public JsonBuilder add(String key, JsonBuilder object) {
		object.addIndents(indents);
		JsonObject obj = new JsonObject(indents, key);
		for (JsonEntry entry : object.entries) {
			obj.add(entry);
		}
		entries.add(obj);
		return this;
	}

	public JsonBuilder addArray(String key, JsonBuilder object) {
		object.addIndents(indents);
		JsonArray arr = new JsonArray(indents, key);
		for (JsonEntry entry : object.entries) {
			arr.add(entry);
		}
		entries.add(arr);
		return this;
	}

	public void addIndents(int indents) {
		this.indents += indents;
		for (int i = 0; i < entries.size(); i++) {
			JsonEntry updated = entries.get(i).addIndents(indents);
			entries.set(i, updated);
		}
	}

	public String get() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");

		for (JsonEntry entry : entries) {
			sb.append(entry.get());
		}
		// Delete last comma
		if (entries.size() > 0) {
			sb.deleteCharAt(sb.length() - 2);
		}

		sb.append('}');
		return sb.toString();
	}
}
