package router

import command.AbsCommand

/**
 * 负责发出指令
 */
interface IPublisher {
    /**
     * 发送指令
     */
    fun onPublish(command: AbsCommand)
}