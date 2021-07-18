function solution(new_id) {
    new_id = new_id
        .toLowerCase()
        .replace(/[^a-z0-9\-\_\.]/g, "")
        .replace(/\.+\./g, ".")
        .replace(/^\./, "")
        .replace(/\.$/, "");
    new_id = (new_id.length === 0) ? "a" : new_id;
    new_id = (new_id.length >= 16) ? new_id.substr(0, 15) : new_id;
    new_id = new_id.replace(/\.$/, "");
    while (new_id.length <= 2) {
        new_id += new_id.charAt(new_id.length - 1);
    }
    return new_id;
}

solution("z-+.^._");