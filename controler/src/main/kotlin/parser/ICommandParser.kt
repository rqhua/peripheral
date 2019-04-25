package parser

import command.AbsCommand

/**
 * 指令解析器
 * 提供标准借口，解析器按标准实现
 */
interface ICommandParser {

    /**
     * 命令解密
     */
    fun decodeCommand(command: AbsCommand)

    /**
     * 密令加密
     */
    fun encodeCommand(command: AbsCommand)

}