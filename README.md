#JSONTools
JsonTools is a simple library written in Java that can programatically generate JSON.

## Usage
To create a JSON string, create a new `JsonBuilder` object. You can add entries with `add(key, value)`.

To use a JSON object as a value, pass a `JsonBuilder` to `add()`.

To use an array as a value, use the method `addArray(key, value)` where `value` has type `JsonBuilder`.

The JSON string is retrieved by calling `get()` on the `JsonBuilder`.

## Example
The following code:
```
new JsonBuilder()
    .add("string_key", "string_value")
    .add("int_key", 10)
    .add("float_key", 2.9)
    .add("double_key", 3.14159)
    .add("bool_key", true)
    .addArray("array_key", new JsonBuilder()
        .add("", "element1")
        .add("", "element2"))
    .add("object_key", new JsonBuilder()
        .add("another_string_key", "another_string_value")
        .addArray("inner_array", new JsonBuilder()
            .add("another_float1", -16.23)
            .add("another_float2", 256.213))).get()
```
returns the following String:
```
{
  "string_key": "string_value",
  "int_key": 10,
  "float_key": 2.9,
  "double_key": 3.14159,
  "bool_key": true,
  "array_key": [
    "element1",
    "element2"
  ],
  "object_key": {
    "another_string_key": "another_string_value",
    "inner_array": [
      -16.23,
      256.213
    ]
  }
}
```