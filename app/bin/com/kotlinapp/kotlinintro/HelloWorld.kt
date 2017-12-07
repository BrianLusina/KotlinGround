fun hello(name: String = ""): String {
    return if (name.trim() == "") "Hello, World!" else "Hello, $name!"
}