# zscro

Searches for a file in the `PATH` environment variable and displays its contents.

## Requirements

Java 25+

## Usage

```bash
./zscro.sh <filename>
```

Or directly:

```bash
java zscro.java <filename>
```

## Example

```bash
java zscro.java gradle
```

Locates and prints the contents of the `gradle` script found in `PATH`.
