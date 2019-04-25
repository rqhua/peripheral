import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    Log.logger.info("main() start")
    /*
    repeat(30) {
        launch {
            delay(2000)
            Log.logger.info("launch in Main Block")
        }
    }

    // 1
    coroutineScope()


    // 2
    cancelCoroutine()
    */
    Log.logger.info("main() end")
}

/**
 * 作用域构建器：在所有的子协程执行完之后才结束
 */
suspend fun coroutineScope(){
    coroutineScope {
        launch {
            delay(3000)
            Log.logger.info("log of launch in coroutineScope")
        }
        Log.logger.info("log of after launch in coroutineScope")
    }
}

/**
 * 协程取消
 */
suspend fun cancelCoroutine(){
    coroutineScope {
        val job = launch {
            repeat(1000) { i ->
                Log.logger.info("I'm sleeping $i ...")
                delay(500L)
            }
        }
        delay(1300L) // 延迟⼀段时间
        Log.logger.info("main: I'm tired of waiting!")
//        job.cancel() // 取消该任务
//        job.join() // 等待任务执⾏结束
        job.cancelAndJoin()
        Log.logger.info("main: Now I can quit.")
    }

}