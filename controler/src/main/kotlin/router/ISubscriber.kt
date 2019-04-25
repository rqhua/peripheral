package router

import command.AbsCommand

/**
 * 负责接收指令
 */
interface ISubscriber {
    /**
     * 接收到指令
     */
    fun onSubscribe(command: AbsCommand)
}