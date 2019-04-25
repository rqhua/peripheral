import org.eclipse.paho.client.mqttv3.*

class MqttWraper @JvmOverloads constructor(private val port: Int, private val ip: String, private val clientId: String, private val callback: MqttCallback = MqttCallbackImpl(), private val username: String = "admin", private val password: String = "public") {
    lateinit var client: MqttClient

    init {
        init()
        connect()
    }

    private fun init() {
        val serverUrl = "tcp://$ip:$port"
        Log.logger.info("serverUrl : $serverUrl port : $port clientId $clientId")
        client = MqttClient(serverUrl, clientId)
        client.setCallback(callback)
    }

    private fun connect() {
        val options = MqttConnectOptions()
        //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
        options.isCleanSession = true
        options.userName = username
        options.password = password.toCharArray()
        options.connectionTimeout = 10
        options.keepAliveInterval = 20
        client.connect(options)
    }

    /**
     * 订阅消息String topicFilter, int qos
     */
    fun subscribe(topicFilter: String, qos: Int) {
        client.subscribe(topicFilter, qos)
    }

    /**
     * 订阅消息
     */
    fun subscribe(topicFilters: Array<String>, qos: IntArray) {
        client.subscribe(topicFilters, qos)
    }

    /**
     * 取消订阅
     */
    fun unSubscribe(topicFilter: String) {
        client.unsubscribe(topicFilter)
    }

    /**
     * 取消订阅
     */
    fun unSubscribe(topicFilters: Array<String>) {
        client.unsubscribe(topicFilters)
    }

    /**
     * 发布消息
     */
    fun publish(topic: String, payload: ByteArray, qos: Int, retained: Boolean) {
        client.publish(topic, payload, qos, retained)
    }

    fun disConnect() {
        client.disconnect()
    }
}