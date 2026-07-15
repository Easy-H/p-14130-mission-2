class Command {

    private var _type: String;
    private val _param = mutableMapOf<String, String>();

    constructor(command: String) {
        val commandSplit = command.split("?", limit = 2);
        _type = commandSplit[0];
        if (commandSplit.size < 2) return;

        val paramSplit = commandSplit[1].split("&");

        for (param in paramSplit) {
            val paramDetail = param.split("=", limit = 2)
            _param[paramDetail[0]] = paramDetail[1]

        }
    }

    fun getType() = _type;
    fun getParam(paramKey: String) = _param[paramKey];
    fun getParamToInt(paramKey: String, defaultValue: Int) : Int {
        return getParam(paramKey)?.toInt() ?: defaultValue;
    }

}