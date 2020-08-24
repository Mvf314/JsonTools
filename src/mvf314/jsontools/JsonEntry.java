package mvf314.jsontools;

public abstract class JsonEntry {

	protected int indents;
	protected final String key;

	public JsonEntry(int indents, String key) {
		this.indents = indents;
		this.key = key;
	}

	public JsonEntry addIndents(int indents) {
		this.indents += indents;
		return this;
	}

	public abstract String get();
	public abstract String getValue();
}
