package router

import command.*

/**
 * 收发消息，并决定如何转发
 * todo 提供路由机制扩展
 */
class Router(val publisher: IPublisher, val subscriber: ISubscriber) {
    /**
     * 发送指令
     */
    fun onPublish(cmd: AbsCommand) {
        publisher.onPublish(cmd)
    }

    /**
     * 接收到指令
     */
    fun onSubscribe(cmd: AbsCommand) {
        subscriber.onSubscribe(cmd)
    }

    fun route(cmd: AbsCommand){
        when(cmd.type) {
            CommandType.SEND -> publisher.onPublish(cmd)


        }
    }

}