void main (String[] args) {
    if (args.length == 0) {
        System.err.println("Usage: java PrintPathFile.java <filename>");
        System.exit(1);
    }

    var filename = args[0];
    var pathEnv = System.getenv("PATH");

    if (pathEnv == null || pathEnv.isBlank()) {
        System.err.println("PATH environment variable is not set");
        System.exit(1);
    }

    var separator = System.getProperty("path.separator");
    var found = Stream.of(pathEnv.split(separator))
            .map(Path::of)
            .map(dir -> dir.resolve(filename))
            .filter(Files::exists)
            .filter(Files::isRegularFile)
            .findFirst();

    if (found.isEmpty()) {
        System.err.println("File not found in PATH: " + filename);
        System.exit(1);
    }

    try {
        Files.lines(found.get()).forEach(System.out::println);
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
        System.exit(1);
    }
}
