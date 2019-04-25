package command

import router.Address

/**
 * 指令抽象
 */
abstract class AbsCommand(val type: CommandType, val address: Address) {

    /**
     * 命令加密
     */
    abstract fun decode()

    /**
     * 命令解密
     */
    abstract fun encode()
}

/**
 * 命令类型：收/发
 */
enum class CommandType(val type: String) {
    /**
     * 发送的指令：此种指令创建之后需要进行加密操作
     */
    SEND("SEND"),
    /**
     * 接收的指令：接收到指令在执行操作前需要进行解密操作
     */
    RECEIVE("SEND")
}