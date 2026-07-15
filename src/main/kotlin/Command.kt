class Command {
    private var _type: String;
    private val _param = mutableMapOf<String, String>();

    constructor(command: String) {
        val commandSplit = command.split("?");
        _type = commandSplit[0];
        if (commandSplit.size < 2) return;
        val paramSplit = commandSplit[1].split("=");
        _param[paramSplit[0]] = paramSplit[1]
    }

    fun getType() = _type;
    fun getParam(paramKey: String) = _param.get(paramKey);

}